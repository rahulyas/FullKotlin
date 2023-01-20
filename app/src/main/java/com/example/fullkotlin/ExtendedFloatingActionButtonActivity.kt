package com.example.fullkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ExtendedFloatingActionButtonActivity : AppCompatActivity() {

    var mAddAlarmFab: FloatingActionButton? = null
    var mAddPersonFab: FloatingActionButton? = null
    var mAddFab: ExtendedFloatingActionButton? = null
    var addAlarmActionText: TextView? = null
    var addPersonActionText: TextView? = null

    var isAllFabsVisible: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extended_floating_action_button)

        mAddFab = findViewById(R.id.add_fab)
        // FAB button
        mAddAlarmFab = findViewById(R.id.add_alarm_fab)
        mAddPersonFab = findViewById(R.id.add_person_fab)

        addAlarmActionText = findViewById(R.id.add_alarm_action_text)
        addPersonActionText = findViewById(R.id.add_person_action_text)


        mAddAlarmFab?.setVisibility(View.GONE)
        mAddPersonFab?.setVisibility(View.GONE)
        addAlarmActionText?.setVisibility(View.GONE)
        addPersonActionText?.setVisibility(View.GONE)


        isAllFabsVisible = false


        mAddFab?.shrink()


        mAddFab?.setOnClickListener{
                    isAllFabsVisible = if (!isAllFabsVisible!!) {

                        mAddAlarmFab?.show()
                        mAddPersonFab?.show()
                        addAlarmActionText?.setVisibility(View.VISIBLE)
                        addPersonActionText?.setVisibility(View.VISIBLE)

                        mAddFab?.extend()

                        true
                    } else {

                        mAddAlarmFab?.hide()
                        mAddPersonFab?.hide()
                        addAlarmActionText?.setVisibility(View.GONE)
                        addPersonActionText?.setVisibility(View.GONE)


                        mAddFab?.shrink()

                        false
                    }
            }

        mAddPersonFab?.setOnClickListener{
            Toast.makeText(this@ExtendedFloatingActionButtonActivity, "Person Added", Toast.LENGTH_SHORT).show()
        }

        mAddAlarmFab?.setOnClickListener{
          Toast.makeText(this@ExtendedFloatingActionButtonActivity, "Alarm Added", Toast.LENGTH_SHORT).show()
        }

    }
}