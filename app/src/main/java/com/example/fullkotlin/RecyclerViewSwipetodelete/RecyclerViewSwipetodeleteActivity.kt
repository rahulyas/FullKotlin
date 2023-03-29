package com.example.fullkotlin.RecyclerViewSwipetodelete

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R
import com.google.android.material.snackbar.Snackbar


class RecyclerViewSwipetodeleteActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var mAdapter: RecyclerViewAdapter? = null
    var stringArrayList: ArrayList<String> = ArrayList()
    var coordinatorLayout: CoordinatorLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_swipetodelete)

        recyclerView = findViewById(R.id.recyclerView)
        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        populateRecyclerView()
        enableSwipeToDeleteAndUndo()
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
        mAdapter = RecyclerViewAdapter(stringArrayList)
        recyclerView!!.adapter = mAdapter
    }

    private fun enableSwipeToDeleteAndUndo() {
        val swipeToDeleteCallback: SwipeToDeleteCallback = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
                val position = viewHolder.adapterPosition
                val item = mAdapter!!.data[position]
                mAdapter!!.removeItem(position)
                val snackbar = coordinatorLayout?.let { Snackbar.make(it, "Item was removed from the list.", Snackbar.LENGTH_LONG) }
                snackbar!!.setAction("UNDO", object : View.OnClickListener {
                    override fun onClick(view: View?) {
                        mAdapter!!.restoreItem(item, position)
                        recyclerView!!.scrollToPosition(position)
                    }
                })
                snackbar.setActionTextColor(Color.YELLOW)
                snackbar.show()
            }
        }
        val itemTouchhelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchhelper.attachToRecyclerView(recyclerView)
    }

}