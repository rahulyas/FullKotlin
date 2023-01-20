package com.example.fullkotlin.RoomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [user1::class], version = 1,exportSchema = false)
abstract class UserDB : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object {
        var INSTANCE: UserDB? = null

        fun getInstance(context: Context): UserDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, UserDB::class.java, "MyApp.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE!!
        }
    }
}