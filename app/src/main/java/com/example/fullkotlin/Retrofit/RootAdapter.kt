package com.example.fullkotlin.Retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R

class RootAdapter(val user: ArrayList<Root>): RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlistuser, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val modle = user[position]
       return holder.bind(user[position])
    }

    override fun getItemCount(): Int {
       return user.size
    }
}

  class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      val textview: TextView = itemView.findViewById(R.id.id)

      val textview1: TextView = itemView.findViewById(R.id.title)
      val textview2: TextView = itemView.findViewById(R.id.body)

      fun bind(root: Root) {
          textview.text="ID: "+root.id
          textview1.text=root.title
          textview2.text=root.body
      }
  }
