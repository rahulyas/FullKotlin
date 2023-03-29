package com.example.fullkotlin

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SharedPreferenceActivity : AppCompatActivity() {
    lateinit var sharedpreferences: SharedPreferences
    var name: TextView? = null
    var email: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        name = findViewById<View>(R.id.etName) as TextView
        email = findViewById<View>(R.id.etEmail) as TextView

        sharedpreferences = getSharedPreferences(Constants.MYPreference, MODE_PRIVATE)
        if (sharedpreferences.contains(Constants.NAME)) {
            name!!.text = sharedpreferences.getString(Constants.NAME, "")
        }
        if (sharedpreferences.contains(Constants.Email)) {
            email!!.text = sharedpreferences.getString(Constants.Email, "")
        }
    }

    fun Save(view: View?) {
        val n = name!!.text.toString()
        val e = email!!.text.toString()
        val editor = sharedpreferences.edit()
        editor.putString(Constants.NAME, n)
        editor.putString(Constants.Email, e)
        editor.commit()
    }

    fun clear(view: View?) {
        name = findViewById<View>(R.id.etName) as TextView
        email = findViewById<View>(R.id.etEmail) as TextView
        name!!.text = ""
        email!!.text = ""
    }

    fun Get(view: View?) {
        name = findViewById<View>(R.id.etName) as TextView
        email = findViewById<View>(R.id.etEmail) as TextView
        sharedpreferences = getSharedPreferences(Constants.MYPreference, MODE_PRIVATE)
        if (sharedpreferences.contains(Constants.NAME)) {
            name!!.text = sharedpreferences.getString(Constants.NAME, "")
        }
        if (sharedpreferences.contains(Constants.Email)) {
            email!!.text = sharedpreferences.getString(Constants.Email, "")
        }
    }
}