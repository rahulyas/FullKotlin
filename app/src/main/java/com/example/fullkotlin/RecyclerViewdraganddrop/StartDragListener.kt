package com.example.fullkotlin.RecyclerViewdraganddrop

import androidx.recyclerview.widget.RecyclerView


interface StartDragListener {
    fun requestDrag(viewHolder: RecyclerView.ViewHolder?)
}
