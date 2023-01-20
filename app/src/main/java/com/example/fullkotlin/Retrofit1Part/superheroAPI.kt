package com.example.fullkotlin.Retrofit1Part

import retrofit2.Call
import retrofit2.http.GET

interface superheroAPI {
    @GET("marvel") // making get request at marvel end-point
    fun getHeroes(): Call<List<Heros?>?>?
}