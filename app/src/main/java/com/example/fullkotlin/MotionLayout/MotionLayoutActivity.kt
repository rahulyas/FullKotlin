package com.example.fullkotlin.MotionLayout

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R
import kotlin.reflect.KClass

data class Step(
    val number: String,
    val name: String,
    val caption: String,
    val activity: KClass<out Activity>,
    val highlight: Boolean = false)

private val data = listOf(
    Step("Step 1", "Animations with Motion Layout",
        "Learn how to build a basic animation with Motion Layout. This will crash until you complete the step in the codelab.",
        Step1Activity::class
    ),
    Step("Step 2",
        "Animating based on drag events",
        "Learn how to control animations with drag events. This will not display any animation until you complete the step in the codelab.",
        Step2Activity::class
    ),
    Step("Completed: Step 3 ",
        "Implements running motion with code",
        "Changes applied from step 3",
        Step3CompletedActivity::class,
        highlight = true
    )
)

class MotionLayoutActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout)

        val recycleview = findViewById<RecyclerView>(R.id.recycle_view2)
        recycleview.adapter = MainAdapter(data)
    }

    class MainAdapter(val data: List<Step>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlist_motion, parent, false)
            return MainViewHolder(view as CardView)
        }

        override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            holder.bind(data[position])
        }

        override fun getItemCount() = data.size

        class MainViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView){
            val header: TextView = cardView.findViewById(R.id.header)
            val description: TextView = cardView.findViewById(R.id.description)
            val caption: TextView = cardView.findViewById(R.id.caption)

            fun bind(step: Step) {
                header.text = step.number
                description.text = step.name
                caption.text = step.caption
                val context = cardView.context
                cardView.setOnClickListener {
                    val intent = Intent(context, step.activity.java)
                    context.startActivity(intent)
                }
                val color = if (step.highlight) {
                    getColor(R.color.purple_200, itemView.context)
                } else {
                    getColor(R.color.purple_500, itemView.context)
                }
                header.setTextColor(color)
                description.setTextColor(color)
            }

            fun getColor(@ColorRes colorResId: Int, context: Context): Int {
                return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    context.resources.getColor(colorResId, context.theme)
                } else {
                    @Suppress("DEPRECATION")
                    context.resources.getColor(colorResId)
                }
            }
        }

    }
}

