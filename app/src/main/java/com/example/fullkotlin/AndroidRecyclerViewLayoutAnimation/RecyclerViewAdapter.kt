package com.example.fullkotlin.AndroidRecyclerViewLayoutAnimation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R


class RecyclerViewAdapter(var itemList: List<String>?) :
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row, viewGroup, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(myViewHolder: ItemViewHolder, position: Int) {
        myViewHolder.tvItem.text = itemList!![position]
    }

    override fun getItemCount(): Int {
        return if (itemList == null) 0 else itemList!!.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvItem: TextView

        init {
            tvItem = itemView.findViewById(R.id.tvItem)
        }
    }
}