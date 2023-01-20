package com.example.fullkotlin.RoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R

class RoomDatabaseActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_database)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView3)

        val btnAdd = findViewById<Button>(R.id.btnAdd)

        Thread {
            val users: List<user1> = UserDB.getInstance(applicationContext).userDao().getAll1() // here we fetch the data from database
            val adapter = RecyclerViewAdapter(users)
            recyclerView.adapter = adapter
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(
                this,
                RecyclerView.VERTICAL,
                false
            )
        }.start()


        btnAdd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}