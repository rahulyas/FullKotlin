package com.example.fullkotlin.AndroidRecyclerViewLayoutAnimation

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class RecycleViewMainActivity : AppCompatActivity() {

    var fab: FloatingActionButton? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewAdapter: RecyclerViewAdapter? = null
    var arrayList: ArrayList<String> = ArrayList()

    var animationList = intArrayOf(
        R.anim.layout_animation_up_to_down,
        R.anim.layout_animation_right_to_left,
        R.anim.layout_animation_down_to_up,
        R.anim.layout_animation_left_to_right
    )

    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_main)


        fab = findViewById(R.id.fab)
        recyclerView = findViewById(R.id.recyclerView)
        populateData()
        initAdapter()

        fab!!.setOnClickListener{
            fun onClick(v: View?) {
                if (i < animationList.size - 1) {
                    i++
                } else {
                    i = 0
                }
                runAnimationAgain()
            }
        }
    }

    private fun populateData() {
        for (i in 0..11) {
            arrayList.add("Item $i")
        }
    }

    private fun initAdapter() {
        recyclerViewAdapter = RecyclerViewAdapter(arrayList)
        recyclerView!!.adapter = recyclerViewAdapter
    }

    private fun runAnimationAgain() {
        val controller: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(
            this,
            animationList[i]
        )
        recyclerView!!.layoutAnimation = controller
        recyclerViewAdapter!!.notifyDataSetChanged()
        recyclerView!!.scheduleLayoutAnimation()
    }

}