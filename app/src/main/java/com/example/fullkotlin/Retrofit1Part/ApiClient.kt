package com.example.fullkotlin.Retrofit1Part

import android.content.Context
import androidx.room.ProvidedAutoMigrationSpec
import com.example.fullkotlin.Retrofit1
import com.example.fullkotlin.db.AppDao
import com.example.fullkotlin.db.AppDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class ApiClient {

    var BASE_URL = "https://simplifiedcoding.net/demos/"

    fun getRetroUnstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetroInstance(retrofit: Retrofit): superheroAPI{
        return retrofit.create(superheroAPI::class.java)
    }


    //database part

    fun getAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getAppDBInstance(context)
    }

    fun getAppDao(appDatabase: AppDatabase): AppDao{
        return appDatabase.getAppDao()
    }

}