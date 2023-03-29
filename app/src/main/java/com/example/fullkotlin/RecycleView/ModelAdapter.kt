package com.example.fullkotlin.RecycleView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R


class ModelAdapter (private val modlelist:ArrayList<Model> ,private val context: Context)
    : RecyclerView.Adapter<ModelAdapter.ModelViewHolder>() {

    var onItemClick: ((Model) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val backgroundColor = ContextCompat.getColor(
            holder.itemView.context,
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) R.color.cold else R.color.coral
        )
        val modle = modlelist[position]
        holder.imageview.setImageResource(modle.image)
        holder.imageview.setBackgroundColor(backgroundColor)
        holder.textview.text = modle.name
        //click Listener to next activity
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(modle)
        }
        //Second Method of click Listener to next activity
        when (position) {
            0 -> holder.itemView.setOnClickListener {
                Toast.makeText(context,"First is selected", Toast.LENGTH_SHORT).show()
//                val intent = Intent(context, ChangeProject::class.java)
//                context.startActivity(intent)
            }
            1 -> holder.itemView.setOnClickListener {
                Toast.makeText(context,"Second is selected", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount(): Int {
        return modlelist.size
    }

    class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageview: ImageView = itemView.findViewById(R.id.imageview)
        val textview: TextView = itemView.findViewById(R.id.name)
    }
}