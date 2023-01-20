package com.example.fullkotlin.RoomDatabase_Retrofit.RetrofitPart

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitInstance {



    //Base Url
    private val BASE_URL = "https://api.github.com/"
    private var retrofit: Retrofit? = null

    // retrofit
    fun getClient(context: Context): Retrofit {

        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


        return retrofit!!
    }


}