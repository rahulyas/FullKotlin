package com.example.fullkotlin.RecyclerViewdraganddrop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R


class RecyclerViewdraganddropActivity : AppCompatActivity() ,StartDragListener {

    var recyclerView: RecyclerView? = null
    var mAdapter: RecyclerViewAdapterdrag? = null
    var stringArrayList: ArrayList<String> = ArrayList()
    var touchHelper: ItemTouchHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_viewdraganddrop)

        recyclerView = findViewById(R.id.recyclerViewdrag)

        populateRecyclerView()
    }

    private fun populateRecyclerView() {
        stringArrayList.add("Item 1")
        stringArrayList.add("Item 2")
        stringArrayList.add("Item 3")
        stringArrayList.add("Item 4")
        stringArrayList.add("Item 5")
        stringArrayList.add("Item 6")
        stringArrayList.add("Item 7")
        stringArrayList.add("Item 8")
        stringArrayList.add("Item 9")
        stringArrayList.add("Item 10")
        mAdapter = RecyclerViewAdapterdrag(stringArrayList, this)
        val callback: ItemTouchHelper.Callback = ItemMoveCallback(mAdapter!!)
        touchHelper = ItemTouchHelper(callback)
        touchHelper!!.attachToRecyclerView(recyclerView)
        recyclerView!!.adapter = mAdapter
    }
    override fun requestDrag(viewHolder: RecyclerView.ViewHolder?) {
        touchHelper!!.startDrag(viewHolder!!)
    }
}

