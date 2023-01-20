package com.example.fullkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fullkotlin.databinding.ActivityBottomNavigationViewBinding


class BottomNavigationView : AppCompatActivity() {

    lateinit var binding: ActivityBottomNavigationViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = getSupportActionBar();

        loadFragement (HomeFragment.newInstance())

        val bottom_navigation = findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnItemSelectedListener { item->
            var fragment :Fragment
            when (item.itemId){
                R.id.nav_home ->{
                    toolbar?.setTitle("Home")
                    fragment = HomeFragment()
                    loadFragement(fragment)
                    true
                }
                R.id.nav_search ->{
                    toolbar?.setTitle("Search")
                    fragment = SearchFragment()
                    loadFragement(fragment)
                    true
                }
             else -> false
            }
        }

        bottom_navigation.setOnItemReselectedListener { item->
            when(item.itemId){
                R.id.nav_home ->{
                    Toast.makeText(this@BottomNavigationView,"Home is selected",Toast.LENGTH_SHORT).show()
                }
                R.id.nav_search -> {
                    Toast.makeText(this@BottomNavigationView,"Search is selected",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun loadFragement(newInstance: Fragment) {
        // load fragement
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,newInstance)
            .commit()

    }
}