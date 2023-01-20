package com.example.fullkotlin.RoomDatabase_Retrofit.Repository

import androidx.lifecycle.LiveData
import com.example.fullkotlin.RoomDatabase_Retrofit.DataBase.UserDao
import com.example.fullkotlin.RoomDatabase_Retrofit.Model.User

class UserLocalRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

}