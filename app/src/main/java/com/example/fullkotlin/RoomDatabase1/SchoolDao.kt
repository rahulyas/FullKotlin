package com.example.fullkotlin.RoomDatabase1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.fullkotlin.RoomDatabase1.entites.Director
import com.example.fullkotlin.RoomDatabase1.entites.School
import com.example.fullkotlin.RoomDatabase1.entites.Student
import com.example.fullkotlin.RoomDatabase1.entites.Subject

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

}