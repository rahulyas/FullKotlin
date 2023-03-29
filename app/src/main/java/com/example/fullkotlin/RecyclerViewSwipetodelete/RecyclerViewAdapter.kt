package com.example.fullkotlin.RecyclerViewSwipetodelete

import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.RelativeLayout
import com.example.fullkotlin.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import java.util.ArrayList

class RecyclerViewAdapter(val data: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mTitle: TextView
        var relativeLayout: RelativeLayout? = null

        init {
            mTitle = itemView.findViewById(R.id.txtTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTitle.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun removeItem(position: Int) {
        data.removeAt(position)
        notifyItemRemoved(position)
    }

    fun restoreItem(item: String, position: Int) {
        data.add(position, item)
        notifyItemInserted(position)
    }
}