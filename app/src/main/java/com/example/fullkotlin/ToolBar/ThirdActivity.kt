package com.example.fullkotlin.ToolBar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.example.fullkotlin.R

class ThirdActivity : AppCompatActivity() {
    private lateinit var btnBack: ImageButton
    private lateinit var btnForward: ImageButton
    private lateinit var tvName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        btnBack = findViewById(R.id.btnBack)
        btnForward = findViewById(R.id.btnForward)
        tvName = findViewById(R.id.tvName)
        tvName.text = "Third"

        btnForward.visibility = View.INVISIBLE
        btnBack.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }

    }
}