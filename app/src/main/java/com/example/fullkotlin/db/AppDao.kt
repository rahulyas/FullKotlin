package com.example.fullkotlin.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fullkotlin.Retrofit1Part.Heros

@Dao
interface AppDao {

//    @Query("SELECT * FFROM herostable")
//    fun getAllRecords(): LiveData<List<Heros>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertRecords(heros: Heros)
//
//    @Query("DELETE FROM herostable")
//    fun deleteAllRecords()
}