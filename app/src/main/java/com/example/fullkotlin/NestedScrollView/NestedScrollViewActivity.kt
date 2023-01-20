package com.example.fullkotlin.NestedScrollView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fullkotlin.R

class NestedScrollViewActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scroll_view)

        val rvContentOne = findViewById<RecyclerView>(R.id.rvContentOne)
        val rvContentTwo = findViewById<RecyclerView>(R.id.rvContentTwo)
        val rvContentThree = findViewById<RecyclerView>(R.id.rvContentThree)


        rvContentOne.adapter = MyAdapter()
        rvContentOne.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        rvContentOne.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        rvContentTwo.adapter = MyAdapter()
        rvContentTwo.addItemDecoration(DividerItemDecoration(this, RecyclerView.HORIZONTAL))
        rvContentTwo.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        rvContentThree.adapter = MyAdapter()
        rvContentThree.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        rvContentThree.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }
}