package com.example.fullkotlin.RecycleView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.fullkotlin.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail"

        val model = intent.getParcelableExtra<Model>("model")
        if(model != null){
            val textview: TextView = findViewById(R.id.textview1)
            val imageView: ImageView = findViewById(R.id.imageview1)

            textview.text = model.name
            imageView.setImageResource(model.image)
        }

    }
}