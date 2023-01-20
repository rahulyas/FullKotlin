package com.example.fullkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CheckBox : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box)

        val allfile = findViewById<android.widget.CheckBox>(R.id.allfile)
        val a = findViewById<android.widget.CheckBox>(R.id.a)
        val b = findViewById<android.widget.CheckBox>(R.id.b)
        val c = findViewById<android.widget.CheckBox>(R.id.c)
        val d = findViewById<android.widget.CheckBox>(R.id.d)

        allfile.setOnCheckedChangeListener { buttonView, isChecked ->
            if (allfile.isChecked){
                a.isChecked = false
                b.isChecked = false
                c.isChecked = false
                d.isChecked = false
            }
        }

        a.setOnCheckedChangeListener { buttonView, isChecked ->
            allfile.isChecked = false
        }

        b.setOnCheckedChangeListener { buttonView, isChecked ->
            allfile.isChecked = false
        }

        c.setOnCheckedChangeListener { buttonView, isChecked ->
            allfile.isChecked = false
        }

        d.setOnCheckedChangeListener { buttonView, isChecked ->
            allfile.isChecked = false
        }

    }
}