package com.example.fullkotlin.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userperson")
data class user1 (
    @PrimaryKey(autoGenerate = true) var id : Long?,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "phone") var phone : String,
    @ColumnInfo(name = "age") var age : Int
){
    constructor() : this(null,"","",0)
}