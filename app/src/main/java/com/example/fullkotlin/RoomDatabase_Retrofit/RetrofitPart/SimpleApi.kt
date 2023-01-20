package com.example.fullkotlin.RoomDatabase_Retrofit.RetrofitPart

import com.example.fullkotlin.RoomDatabase_Retrofit.Model.User
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET("users")
    suspend fun getUser(): Response<List<User>>
}