package com.example.fullkotlin.Retrofit

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Root::class], version = 1, exportSchema = false)
public abstract class RootDatabase : RoomDatabase() {


//     abstract fun rootDao(): RootDao
    companion object {

        @Volatile
        private var INSTANCE: RootDatabase? = null

        fun getDatabase(context: Context): RootDatabase? {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RootDatabase::class.java,
                    "Msg_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }

    }
}