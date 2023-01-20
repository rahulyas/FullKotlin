package com.example.fullkotlin.UsingNavigationComponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fullkotlin.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavigationBottomNavigation : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_bottom_navigation)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation1)
        navController = findNavController(R.id.fragment_container1)
        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_first1,R.id.nav_second2))
        setupActionBarWithNavController(navController,appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)
    }
}