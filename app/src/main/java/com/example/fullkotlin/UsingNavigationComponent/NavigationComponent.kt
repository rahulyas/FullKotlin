package com.example.fullkotlin.UsingNavigationComponent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fullkotlin.databinding.ActivityNavigationComponentBinding

class NavigationComponent : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_navigation_component)

        binding = ActivityNavigationComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigationdrawer.setOnClickListener {
            val intent = Intent(this, NavigationDrawerwithNavigation::class.java)
            startActivity(intent)
        }

        binding.bottomnavigation.setOnClickListener {
            val intent = Intent(this, NavigationBottomNavigation::class.java)
            startActivity(intent)
        }

        binding.viewpager.setOnClickListener {

        }

        binding.bottomsheet.setOnClickListener {

        }

    }
}