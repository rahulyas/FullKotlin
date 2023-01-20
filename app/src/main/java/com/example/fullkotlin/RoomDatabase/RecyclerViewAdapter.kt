package com.example.fullkotlin.RoomDatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R

class RecyclerViewAdapter(var users : List<user1>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.recyclerview_item1, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int = users.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
        var tvAge: TextView = itemView.findViewById(R.id.tvAge)

        fun bind(user1: user1) {
            tvName.text = user1.name
            tvPhone.text = user1.phone
            tvAge.text = user1.age.toString()
        }
    }
}