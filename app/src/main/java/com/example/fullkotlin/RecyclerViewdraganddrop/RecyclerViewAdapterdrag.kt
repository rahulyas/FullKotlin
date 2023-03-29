package com.example.fullkotlin.RecyclerViewdraganddrop

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R
import com.example.fullkotlin.RecyclerViewdraganddrop.ItemMoveCallback.ItemTouchHelperContract
import java.util.*

class RecyclerViewAdapterdrag(data: ArrayList<String>, startDragListener: StartDragListener) :
    RecyclerView.Adapter<RecyclerViewAdapterdrag.MyViewHolder>(), ItemTouchHelperContract {
    private val data: ArrayList<String>
    private val mStartDragListener: StartDragListener

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTitle: TextView
        var rowView: View
        var imageView: ImageView

        init {
            rowView = itemView
            mTitle = itemView.findViewById(R.id.txtTitle)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }

    init {
        mStartDragListener = startDragListener
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.cardview_row, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTitle.text = data[position]
        holder.imageView.setOnTouchListener { v, event ->
            if (event.action ==
                MotionEvent.ACTION_DOWN
            ) {
                mStartDragListener.requestDrag(holder)
            }
            false
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onRowMoved(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(data, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(data, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onRowSelected(myViewHolder: MyViewHolder?) {
        myViewHolder!!.rowView.setBackgroundColor(Color.GRAY)
    }

    override fun onRowClear(myViewHolder: MyViewHolder?) {
        myViewHolder!!.rowView.setBackgroundColor(Color.WHITE)
    }


}
