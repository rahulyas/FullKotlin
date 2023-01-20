package com.example.fullkotlin.RoomDatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.fullkotlin.ArrayList.User
import com.example.fullkotlin.R

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val btnAdd = findViewById<Button>(R.id.btnok)
        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etAge = findViewById<EditText>(R.id.etAge)

        btnAdd.setOnClickListener {
            Thread{
                var name = etName.text.toString()
                var phone = etPhone.text.toString()
                var age = Integer.parseInt(etAge.text.toString())

                var user = user1(null,name,phone,age)
                // here we insert the data in room database
                UserDB.getInstance(applicationContext).userDao().insert(user)

                val intent = Intent(this, RoomDatabaseActivity::class.java)
                startActivity(intent)

            }.start()
        }
    }
}