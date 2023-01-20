package com.example.fullkotlin.RoomDatabase_Retrofit.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.fullkotlin.RoomDatabase_Retrofit.Model.User

@Dao
interface UserDao {


    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM User ORDER BY id DESC")
    fun readAllData(): LiveData<List<User>>

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM User")
    suspend fun deleteAllUsers()

}