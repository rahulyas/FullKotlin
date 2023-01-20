package com.example.fullkotlin.Retrofit1Part

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "herostable")
data class Heros(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    var name: String,
    var realname: String,
    var team: String,
    var firstappearance: String,
    var createdby: String,
    var publisher: String,
    var imageurl: String,
    var bio: String

    )