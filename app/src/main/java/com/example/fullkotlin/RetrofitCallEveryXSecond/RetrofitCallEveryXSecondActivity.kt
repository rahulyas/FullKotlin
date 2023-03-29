package com.example.fullkotlin.RetrofitCallEveryXSecond

import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fullkotlin.R
import com.example.fullkotlin.RetrofitCallEveryXSecond.APIService.Companion.BASE_URL
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import io.reactivex.Observable
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory


class RetrofitCallEveryXSecondActivity : AppCompatActivity() {
    var retrofit: Retrofit? = null
    var textView: TextView? = null
    var apiService: APIService? = null
    var disposable: Disposable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_call_every_xsecond)

        textView = findViewById(R.id.textView)

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()


        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        apiService = retrofit!!.create(APIService::class.java)


        disposable = Observable.interval(
            1000, 5000,
            TimeUnit.MILLISECONDS
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::callJokesEndpoint, this::onError)

    }

    override fun onResume() {
        super.onResume()
        if (disposable!!.isDisposed) {
            disposable = Observable.interval(
                1000, 5000,
                TimeUnit.MILLISECONDS
            )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ aLong: Long -> callJokesEndpoint(aLong) }) { throwable: Throwable ->
                    onError(
                        throwable
                    )
                }
        }
    }

    private fun callJokesEndpoint(aLong: Long) {
        val observable: Observable<Jokes?>? = apiService!!.getRandomJoke("random")
        observable!!.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
            .map { result -> result.value }
            .subscribe({ joke: String -> handleResults(joke) } as ((String?) -> Unit)?) { t: Throwable ->
                handleError(
                    t
                )
            }
    }

    private fun onError(throwable: Throwable) {
        Toast.makeText(
            this, "OnError in Observable Timer",
            Toast.LENGTH_LONG
        ).show()
    }


    private fun handleResults(joke: String) {
        if (!TextUtils.isEmpty(joke)) {
            textView!!.text = joke
        } else {
            Toast.makeText(
                this, "NO RESULTS FOUND",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun handleError(t: Throwable) {

        //Add your error here.
    }

    override fun onPause() {
        super.onPause()
        disposable!!.dispose()
    }

}