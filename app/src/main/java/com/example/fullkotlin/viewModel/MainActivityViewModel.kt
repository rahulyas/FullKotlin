package com.example.fullkotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.fullkotlin.Retrofit1Part.Heros
import com.example.fullkotlin.Retrofit1Part.superheroAPI
import retrofit2.Call

class MainActivityViewModel constructor(private val superheroAPI: superheroAPI)
    : ViewModel() {

    fun getAllRepositoryList(): Call<List<Heros?>?>? {
        return superheroAPI.getHeroes()
    }

    fun makeApiCall(){
        superheroAPI.getHeroes()
    }
}