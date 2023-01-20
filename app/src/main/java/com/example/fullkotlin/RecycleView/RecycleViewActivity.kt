package com.example.fullkotlin.RecycleView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R

class RecycleViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var modlelist :ArrayList<Model>
    private lateinit var modelAdapter: ModelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        recyclerView  = findViewById(R.id.recycleview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        modlelist = ArrayList()

        modlelist.add(Model(R.color.black,"A"))
        modlelist.add(Model(R.color.purple_200,"B"))
        modlelist.add(Model(R.color.purple_500,"C"))
        modlelist.add(Model(R.color.purple_700,"D"))
        modlelist.add(Model(R.color.teal_200,"E"))
        modlelist.add(Model(R.color.teal_700,"F"))

        modelAdapter = ModelAdapter(modlelist,this)
        recyclerView.adapter = modelAdapter

        modelAdapter.onItemClick={
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("model",it)
            startActivity(intent)
        }

    }
}