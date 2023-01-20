package com.example.fullkotlin.Retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    lateinit var  userlist:ArrayList<Root>
    lateinit var rootAdapter: RootAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        val msgRepo : RootRepository by lazy {
            RootRepository(this@RetrofitActivity)
        }

        recyclerView  = findViewById(R.id.recyclerView1)

        val progres_bar = findViewById<ProgressBar>(R.id.progress_bar)
        //Retrofit
        val apiClient = ApiClient()
        val apiService: ApiInterface = apiClient.getClient(this).create(ApiInterface::class.java)
        val call: Call<List<Root>> =apiService.allTag
        call.enqueue(object : Callback<List<Root>>{
            override fun onResponse(call: Call<List<Root>>, response: Response<List<Root>>) {
//                try {
//                    val res = response.body()
//                    progres_bar.visibility = View.GONE
//                    Toast.makeText(this@RetrofitActivity,"Response get from the server successfully ",Toast.LENGTH_SHORT).show()
//                }catch (ex :java.lang.Exception){
//
//                }
                if (response.isSuccessful) {
                    progres_bar.visibility = View.GONE
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@RetrofitActivity)
                        adapter = RootAdapter(response.body() as ArrayList<Root>)
                    }
//                    msgRepo.appdb.insert(response)
                    Toast.makeText(this@RetrofitActivity,"Response get from the server successfully ",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Root>>, t: Throwable) {
                Toast.makeText(this@RetrofitActivity,"Response Failed",Toast.LENGTH_SHORT).show()
            }

        })


    }
}

