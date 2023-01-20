package com.example.fullkotlin.ArrayList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fullkotlin.R

class ArrayListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_array_list)

        val users: ArrayList<User<String, Int>> = ArrayList()
        users.add(User("Rahul", 30))

        showUsers(users)
    }

    private fun showUsers(users: ArrayList<User<String, Int>>) {
        users.add(User("Tushar", 27))

        for (i in 0 until users.size) {
            Log.e("name", users[i].name)
            Log.e("age", users[i].age.toString())
        }
    }
}