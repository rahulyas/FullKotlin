package com.example.fullkotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.fullkotlin.Expanded.ExpandedMenuAdapter
import com.example.fullkotlin.Expanded.ExpandedMenuModel
import com.example.fullkotlin.databinding.ActivityExpandablelistviewnavigationdrawerBinding
import java.util.HashMap

class Expandablelistviewnavigationdrawer : AppCompatActivity() {

    private lateinit var binding: ActivityExpandablelistviewnavigationdrawerBinding

    private var viewGroup: View? = null

    private val headerList: ArrayList<ExpandedMenuModel> = ArrayList<ExpandedMenuModel>()
    private val childList: HashMap<ExpandedMenuModel, ArrayList<String>> = HashMap<ExpandedMenuModel, ArrayList<String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_expandablelistviewnavigationdrawer)

        binding = ActivityExpandablelistviewnavigationdrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareListData()

        //Initialize and Assign ExpandableListView
        val expandableListView: ExpandableListView = binding.expandedListView

        //Set Adapter in ExpandableListView :
        val mMenuAdapter = ExpandedMenuAdapter(this, headerList, childList, expandableListView)
        expandableListView.setAdapter(mMenuAdapter)

        expandableListView.choiceMode = ExpandableListView.CHOICE_MODE_SINGLE

        expandableListView.setOnGroupClickListener { parent, _, groupPosition, _ ->
            when (groupPosition) {

                0 -> {
                    if (parent.isGroupExpanded(groupPosition)) {
                        parent.collapseGroup(groupPosition)
                    } else {
                        parent.expandGroup(groupPosition)

                        parent.setOnChildClickListener { parent, view, groupPosition, childPosition, _ ->
                            view.isSelected = true
                            viewGroup?.setBackgroundColor(Color.parseColor("#FFFFFF"))
                            viewGroup = view
                            viewGroup?.setBackgroundColor(Color.parseColor("#2ba89c"))

                            binding.drawerLayout.closeDrawer(GravityCompat.START)
                            when (childPosition) {
                                0 -> {
//                                        val myFragment = ChangeProject()
//                                        val fragment : Fragment? = supportFragmentManager.findFragmentByTag(ChangeProject::class.java.simpleName)
//                                        if(fragment !is ChangeProject){
//                                            supportFragmentManager.beginTransaction()
//                                                .add(R.id.nav_host_fragment_content_main, myFragment,ChangeProject::class.java.simpleName)
//                                                .commit()
//                                        }

                                }

                                1 -> {
                                    val items = arrayOf("BASE", "ROVER")
                                    val builder = android.app.AlertDialog.Builder(this)
                                    with(builder) {
                                        setTitle("Select")
                                        setItems(items) { dialog, which ->
                                            when (which) {
                                                0 -> {
//                                                    val intent = Intent(this@MainActivity, BaseAcivity::class.java)
//                                                    startActivity(intent)
                                                }

                                                1 -> {
//                                                    val intent = Intent(this@MainActivity, RoverActivity::class.java)
//                                                    startActivity(intent)
                                                }

                                            }

                                        }
                                    }
                                    builder.show()
                                }

                                2 -> {

                                }

                            }
                            parent.expandGroup(groupPosition)
                        }
                    }
                }

                1 -> {
                    if (parent.isGroupExpanded(groupPosition)) {
                        parent.collapseGroup(groupPosition)
                    } else {
                        parent.expandGroup(groupPosition)
                        parent.setOnChildClickListener { parent, view, groupPosition, childPosition, _ ->
                            view.isSelected = true;
                            viewGroup?.setBackgroundColor(Color.parseColor("#FFFFFF"))
                            viewGroup = view;
                            viewGroup?.setBackgroundColor(Color.parseColor("#2ba89c"))
                            binding.drawerLayout.closeDrawer(GravityCompat.START)
                            when (childPosition) {
                                0 -> {

                                }
                                1 -> {

                                }
                                2 -> {

                                }
                                3 -> {

                                }
                            }
                            parent.expandGroup(groupPosition)
                        }
                    }
                }

                2 -> {

                }

                3 -> {
                    if (parent.isGroupExpanded(groupPosition)) {
                        parent.collapseGroup(groupPosition)
                    } else {
                        parent.expandGroup(groupPosition)

                        parent.setOnChildClickListener { parent, view, groupPosition, childPosition, _ ->
                            view.isSelected = true
                            viewGroup?.setBackgroundColor(Color.parseColor("#FFFFFF"))
                            viewGroup = view
                            viewGroup?.setBackgroundColor(Color.parseColor("#2ba89c"))

                            binding.drawerLayout.closeDrawer(GravityCompat.START)
                            when (childPosition) {
                                0 -> {

                                }
                                1 -> {

                                }
                                2 -> {

                                }
                                3 -> {
                                    Toast.makeText(this,"Selected", Toast.LENGTH_SHORT).show()
                                }

                            }
                            parent.expandGroup(groupPosition)
                        }
                    }
                }

                4 -> {
                    if (parent.isGroupExpanded(groupPosition)) {
                        parent.collapseGroup(groupPosition)
                    } else {
                        parent.expandGroup(groupPosition)

                        parent.setOnChildClickListener { parent, view, groupPosition, childPosition, _ ->
                            view.isSelected = true
                            viewGroup?.setBackgroundColor(Color.parseColor("#FFFFFF"))
                            viewGroup = view
                            viewGroup?.setBackgroundColor(Color.parseColor("#2ba89c"))

                            binding.drawerLayout.closeDrawer(GravityCompat.START)
                            when (childPosition) {
                                0 -> {

                                }

                                1 -> {

                                }

                                2 -> {

                                }

                            }
                            parent.expandGroup(groupPosition)
                        }
                    }
                }

                5 -> {

                }


            }
            true
        }

    }

    private fun prepareListData() {

        val headerFirst = ExpandedMenuModel()
        headerFirst.itemName = ("P")
//        headerFirst.itemIcon = R.drawable.ic_menu_camera

        headerList.add(headerFirst)

        val headerSecond = ExpandedMenuModel()
        headerSecond.itemName = ("M")
//        headerSecond.itemIcon = R.drawable.ic_menu_camera

        headerList.add(headerSecond)
        val headerThrid = ExpandedMenuModel()
        headerThrid.itemName = ("S")
        headerList.add(headerThrid)

        val headerfourth = ExpandedMenuModel()
        headerfourth.itemName = ("C")
        headerList.add(headerfourth)

        val headerFifth = ExpandedMenuModel()
        headerFifth.itemName = ("D")
        headerList.add(headerFifth)

        val headerSixth = ExpandedMenuModel()
        headerSixth.itemName = ("")
        headerList.add(headerSixth)

//        val headerSeventh = ExpandedMenuModel()
//        headerSeventh.itemName = ("Exit")
//        headerList.add(headerSeventh)


        val childFirst = ArrayList<String>()
        childFirst.add("C")
        childFirst.add("C")
        childFirst.add("A")

        val childSecond = ArrayList<String>()
        childSecond.add("T")
        childSecond.add("A")
        childSecond.add("C")
        childSecond.add("S")

        val childThird = ArrayList<String>()
        childThird.add("S")

        val childFourth = ArrayList<String>()
        childFourth.add("C")
        childFourth.add("C")
        childFourth.add("C Down")
        childFourth.add("CV")


        val childFifth = ArrayList<String>()
        childFifth.add("P")
        childFifth.add("I")
        childFifth.add("E")

        childList[headerList[0]] = childFirst
        childList[headerList[1]] = childSecond
        childList[headerList[2]] = childThird
        childList[headerList[3]] = childFourth
        childList[headerList[4]] = childFifth


    }
}