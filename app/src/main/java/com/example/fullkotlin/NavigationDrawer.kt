package com.example.fullkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.fullkotlin.databinding.ActivityBottomNavigationViewBinding
import com.example.fullkotlin.databinding.ActivityNavigationDrawerBinding
import com.google.android.material.navigation.NavigationView
import java.util.zip.Inflater

class NavigationDrawer : AppCompatActivity() {

    lateinit var binding: ActivityNavigationDrawerBinding
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navigationView = findViewById<NavigationView>(R.id.navView)

        binding.apply {
            toggle = ActionBarDrawerToggle(this@NavigationDrawer,drawerLayout,R.string.open,R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navigationView.setNavigationItemSelectedListener {
                drawerLayout.closeDrawers()
                when (it.itemId){
                    R.id.nav_home1 ->{
                        Toast.makeText(this@NavigationDrawer,"Home is Selected",Toast.LENGTH_SHORT).show()
                    }

                    R.id.nav_meassage ->{
                        Toast.makeText(this@NavigationDrawer,"Meassage is Selected",Toast.LENGTH_SHORT).show()
                    }

                    R.id.nav_sync ->{
                        Toast.makeText(this@NavigationDrawer,"Sync is Selected",Toast.LENGTH_SHORT).show()
                    }

                    R.id.nav_trash ->{
                        Toast.makeText(this@NavigationDrawer,"Trash is Selected",Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

}