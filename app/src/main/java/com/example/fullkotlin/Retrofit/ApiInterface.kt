package com.example.fullkotlin.Retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @get:GET("/posts")
    val allTag: Call<List<Root>>
}