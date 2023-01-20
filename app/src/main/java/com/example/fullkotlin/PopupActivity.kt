package com.example.fullkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class PopupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

        val popupbutton = findViewById<Button>(R.id.popup_button)

        popupbutton.setOnClickListener {
            showPopup(popupbutton)
        }

    }

    private fun showPopup(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.nav_first -> {
                    Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, Activity2::class.java)
//                    startActivity(intent)
                }
                R.id.nav_second -> {
                    Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
}