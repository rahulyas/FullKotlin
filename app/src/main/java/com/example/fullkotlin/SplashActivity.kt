package com.example.fullkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {

    companion object {

        private const val logoTime = 1000L

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        showLogo()
    }

    private fun showLogo() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val appIntent = Intent(
                    this,
                    MainActivity::class.java
                )
                startActivity(appIntent)
                finish()
            },
            logoTime
        )
    }

}