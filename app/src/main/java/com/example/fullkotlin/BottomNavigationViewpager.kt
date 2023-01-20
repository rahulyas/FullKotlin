package com.example.fullkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.fullkotlin.databinding.ActivityBottomNavigationViewpagerBinding

class BottomNavigationViewpager : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationViewpagerBinding
//    private var vBinding :  ActivityBottomNavigationViewpagerBinding? = null
//    private val binding get() = vBinding!!
//
//    var viewList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationViewpagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager1)


        viewPager.adapter = FragmentAdapter(this)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
            }
            return@setOnNavigationItemSelectedListener true
        }

//        viewList.add(layoutInflater.inflate(R.layout.fragment_home, null))
//        viewList.add(layoutInflater.inflate(R.layout.fragment_search, null))
//
//        binding.viewPager.adapter = pagerAdapter()
//
//        binding.viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
//            override fun onPageSelected(position: Int) {
//                when(position) {
//                    0 -> binding.bottomNavigationView.selectedItemId = R.id.home
//                    1 -> binding.bottomNavigationView.selectedItemId = R.id.favorite
//                }
//            }
//        })
//
//        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
//            when(it.itemId) {
//                R.id.home -> binding.viewPager.setCurrentItem(0)
//                R.id.favorite -> binding.viewPager.setCurrentItem(1)
//            }
//            return@setOnNavigationItemSelectedListener true
//        }
    }
    class FragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int {
            return 2
        }

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> HomeFragment.newInstance()
                1 -> SearchFragment.newInstance()
                else -> HomeFragment.newInstance()
            }
        }
    }
//    inner class pagerAdapter : PagerAdapter() {
//
//        override fun getCount() = viewList.size
//
//        override fun isViewFromObject(view: View, `object`: Any) = view == `object`
//
//        override fun instantiateItem(container: ViewGroup, position: Int): Any {
//            var curView = viewList[position]
//            binding.viewPager.addView(curView)
//            return curView
//        }
//
//        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//            binding.viewPager.removeView(`object` as View)
//        }
//
//    }
//
//    override fun onDestroy() {
//        vBinding = null
//        super.onDestroy()
//    }
}