package com.example.fullkotlin.CustomNavigationDrawer

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R

class NavigationRVAdapter(private var items: ArrayList<NavigationItemModel>, private var currentPos: Int) :
    RecyclerView.Adapter<NavigationItemViewHolder>() {

    private lateinit var context: Context

//    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationItemViewHolder {
        context = parent.context
        val navItem = LayoutInflater.from(parent.context).inflate(R.layout.row_nav_drawer, parent, false)
        return NavigationItemViewHolder(navItem)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: NavigationItemViewHolder, position: Int) {
        // To highlight the selected item, show different background color
        if (position == currentPos) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.cold))
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
        }

        holder.navigation_icon.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP)
        holder.navigation_title.setTextColor(Color.WHITE)
        //val font = ResourcesCompat.getFont(context, R.font.mycustomfont)
        //holder.navigation_text.typeface = font
        //holder.navigation_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat())

        holder.navigation_title.text = items[position].title

        holder.navigation_icon.setImageResource(items[position].icon)


    }
}

    class NavigationItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val navigation_icon: ImageView = itemView.findViewById(R.id.navigation_icon)

    val navigation_title: TextView = itemView.findViewById(R.id.navigation_title)


}