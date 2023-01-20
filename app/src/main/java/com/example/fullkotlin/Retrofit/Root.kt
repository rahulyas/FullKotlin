package com.example.fullkotlin.Retrofit

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.annotation.JsonProperty

//data class Root(
//    val root : List<Root2>
//)

@Entity(tableName = "root")
data class Root(
    val userId: Long,
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val body: String,
)
