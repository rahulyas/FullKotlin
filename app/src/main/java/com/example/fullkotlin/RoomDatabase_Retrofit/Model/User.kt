package com.example.fullkotlin.RoomDatabase_Retrofit.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val login: String,
    val type: String,
    val avatar_url: String
)