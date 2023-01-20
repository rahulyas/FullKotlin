package com.example.fullkotlin.Retrofit1Part

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.fullkotlin.db.AppDao
import com.fasterxml.jackson.annotation.JacksonInject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetroRepository  constructor(private val superheroAPI: superheroAPI, private val appDao: AppDao)  {

//    fun getAllRecords(): LiveData<List<Heros>>{
//        return appDao.getAllRecords()
//    }
//
//    fun insertRecord(heros: Heros){
//        appDao.insertRecords(heros)
//    }
//
//    //get the data from api....
//
//    fun makeApiCall(query: String?){
//        val call: Call<List<Heros?>?>? = superheroAPI.getHeroes()
//
//        call?.enqueue(object : Callback<List<Heros?>?>{
//            override fun onResponse(call: Call<List<Heros?>?>, response: Response<List<Heros?>?>) {
//                if(response.isSuccessful){
//                    appDao.deleteAllRecords()
//                    response.body()?.forEach {
//                        insertRecord(it!!)
//
//                    }
//
//                }
//            }
//
//            override fun onFailure(call: Call<List<Heros?>?>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//
//    }
}