package com.example.fullkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.fullkotlin.databinding.ActivitySpinnerBinding

class Spinner : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivitySpinnerBinding
    // string variable to store selected values
    var selectedClass: String? = null
    var selectedDiv: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val classSpinner = findViewById<android.widget.Spinner>(R.id.classSpinner)
        val divSpinner = findViewById<android.widget.Spinner>(R.id.divSpinner)


        val adapter = ArrayAdapter.createFromResource(this,R.array.items_class,android.R.layout.simple_list_item_1)
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)

        classSpinner.adapter = adapter
        classSpinner.onItemSelectedListener = this@Spinner

        val adapter1 = ArrayAdapter.createFromResource(this,R.array.items_div_class_1,android.R.layout.simple_list_item_1)
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_1)
        val adapter2 = ArrayAdapter.createFromResource(this,R.array.items_div_class_2,android.R.layout.simple_list_item_1)
        adapter2.setDropDownViewResource(android.R.layout.simple_list_item_1)
        val adapter3 = ArrayAdapter.createFromResource(this,R.array.items_div_class_3,android.R.layout.simple_list_item_1)
        adapter3.setDropDownViewResource(android.R.layout.simple_list_item_1)
        val adapter4 = ArrayAdapter.createFromResource(this,R.array.items_div_class_4,android.R.layout.simple_list_item_1)
        adapter4.setDropDownViewResource(android.R.layout.simple_list_item_1)

        divSpinner.adapter = adapter1
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedClass = parent?.getItemAtPosition(position).toString()
        binding.divSpinner.visibility = View.VISIBLE
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        binding.divSpinner.visibility = View.INVISIBLE
    }

}