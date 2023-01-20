package com.example.fullkotlin.UsingNavigationComponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fullkotlin.R
import com.google.android.material.navigation.NavigationView

class NavigationDrawerwithNavigation : AppCompatActivity() {

    private lateinit var navController : NavController
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration

    private lateinit var listener: NavController.OnDestinationChangedListener

//    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawerwith_navigation)


         val naviagtionView = findViewById<NavigationView>(R.id.naviagtionView)
         val navHostFragment = supportFragmentManager.findFragmentById(R.id.navfragment)
//         navController = findNavController(R.id.navfragment)
         navController = navHostFragment!!.findNavController()

         drawerLayout = findViewById(R.id.navdrawerLayout)
         appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_first1,R.id.nav_second2),drawerLayout)


        setupActionBarWithNavController(navController,appBarConfiguration)
        naviagtionView.setupWithNavController(navController)

        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->

            if (destination.id == R.id.nav_firstfragment){
//                supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_200)))
                Toast.makeText(this@NavigationDrawerwithNavigation, "Ok", Toast.LENGTH_LONG).show()
        }else if (destination.id == R.id.nav_secondfragment){
//            supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.purple_500)))
                Toast.makeText(this@NavigationDrawerwithNavigation, "Fine", Toast.LENGTH_LONG).show()

            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navfragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}