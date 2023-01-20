package com.example.fullkotlin.RoomDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userperson: user1)

    @Query("SELECT * FROM userperson ORDER BY age ASC")
    fun getAll1(): List<user1>
}