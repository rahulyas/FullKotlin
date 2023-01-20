package com.example.fullkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.helper.widget.Carousel
import androidx.navigation.Navigation
import com.example.fullkotlin.ArrayList.ArrayListActivity
import com.example.fullkotlin.Bluetooth.BluetoothActivity
import com.example.fullkotlin.Carousel.CarouselActivity
import com.example.fullkotlin.CustomNavigationDrawer.CustomNavigationDrawerActivity
import com.example.fullkotlin.MotionLayout.MotionLayoutActivity
import com.example.fullkotlin.NestedScrollView.NestedScrollViewActivity
import com.example.fullkotlin.RecycleView.RecycleViewActivity
import com.example.fullkotlin.Retrofit.RetrofitActivity
import com.example.fullkotlin.RoomDatabase.RoomDatabaseActivity
import com.example.fullkotlin.RoomDatabase1.RoomDatabase1Activity
import com.example.fullkotlin.SqliteDatabase.SqliteDatabaseActivity
import com.example.fullkotlin.TabLayout.TabLayoutActivity
import com.example.fullkotlin.ToolBar.ToolBarMainActivity
import com.example.fullkotlin.UsingNavigationComponent.NavigationComponent
import com.example.fullkotlin.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = findViewById<Button>(R.id.btnBottomSheetPersistent)
        val bottomnavigation = findViewById<AppCompatButton>(R.id.btnBottomNavigation)
        val bottomnavigationviewpager = findViewById<AppCompatButton>(R.id.btnBottomNavigation1)
        val navigationdrawer = findViewById<AppCompatButton>(R.id.btnNavigationDrawer)
        val retrofit = findViewById<AppCompatButton>(R.id.btnRetrofit)
        val checkBox = findViewById<AppCompatButton>(R.id.btncheckbox)
        val spinner = findViewById<AppCompatButton>(R.id.btnspinner)
        val recyclerView = findViewById<AppCompatButton>(R.id.btnrecycleview)
        val alertDialog = findViewById<AppCompatButton>(R.id.btnalertdialog)
        val retorfit1 = findViewById<AppCompatButton>(R.id.btnretrofit)
        val sqlitedatabase = findViewById<AppCompatButton>(R.id.btnsqlitedatabase)
        val motionlayout = findViewById<AppCompatButton>(R.id.btnmotionlayout)
        val bluetooth = findViewById<AppCompatButton>(R.id.btnbluetooth)
        val nestedscrollview = findViewById<AppCompatButton>(R.id.btnnestedscrollview)
        val arraylist = findViewById<AppCompatButton>(R.id.btnarraylist)
        val toolbar = findViewById<AppCompatButton>(R.id.btntoolbar)
        val roomdatabase = findViewById<AppCompatButton>(R.id.btnroomdatabase)
        val roomdatabase1 = findViewById<AppCompatButton>(R.id.btnroomdatabase1)
        val animation = findViewById<AppCompatButton>(R.id.btnanimation)
        val tablayout = findViewById<AppCompatButton>(R.id.btntablayout)
        val expandablelistviewnavigationdrawer = findViewById<AppCompatButton>(R.id.expandablelistviewnavigationdrawer)
        val popup = findViewById<AppCompatButton>(R.id.popup)


        binding.btnBottomSheetPersistent.setOnClickListener {
            CustomBottomSheetDialogFragment().apply {
                show(supportFragmentManager,CustomBottomSheetDialogFragment.TAG)
            }
        }

        binding.btnBottomNavigation.setOnClickListener {
            val intent = Intent(this,BottomNavigationView::class.java)
            startActivity(intent)

        }

        binding.btnBottomNavigation1.setOnClickListener {
            val intent = Intent(this,BottomNavigationViewpager::class.java)
            startActivity(intent)

        }

        binding.btnNavigationDrawer.setOnClickListener {
            val intent = Intent(this,NavigationDrawer::class.java)
            startActivity(intent)
        }

        binding.btnNavigationDrawerusingfragment.setOnClickListener {
            val intent = Intent(this,NavigationDrawerUsingFragment::class.java)
            startActivity(intent)
        }


        binding.btnRetrofit.setOnClickListener {
            val intent = Intent(this,Retrofit1::class.java)
            startActivity(intent)
        }

        binding.btncheckbox.setOnClickListener {
            val intent = Intent(this,CheckBox::class.java)
            startActivity(intent)
        }

        binding.btnspinner.setOnClickListener {
            val intent = Intent(this,Spinner::class.java)
            startActivity(intent)
        }

        binding.btnrecycleview.setOnClickListener {
            val intent = Intent(this,RecycleViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnalertdialog.setOnClickListener {
            val intent = Intent(this,AlertDialogActivity::class.java)
            startActivity(intent)
        }

        binding.btnretrofit.setOnClickListener {
            val intent = Intent(this,RetrofitActivity::class.java)
            startActivity(intent)
        }

        binding.btnsqlitedatabase.setOnClickListener {
            val intent = Intent(this,SqliteDatabaseActivity::class.java)
            startActivity(intent)
        }

        binding.btnmotionlayout.setOnClickListener {
            val intent = Intent(this,MotionLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnbluetooth.setOnClickListener {
            val intent = Intent(this,BluetoothActivity::class.java)
            startActivity(intent)
        }

        binding.btnnestedscrollview.setOnClickListener {
            val intent = Intent(this, NestedScrollViewActivity::class.java)
            startActivity(intent)
        }

        binding.btnarraylist.setOnClickListener {
            val intent = Intent(this,ArrayListActivity::class.java)
            startActivity(intent)
        }

        binding.btntoolbar.setOnClickListener {
            val intent = Intent(this,ToolBarMainActivity::class.java)
            startActivity(intent)
        }

        binding.btnroomdatabase.setOnClickListener {
            val intent = Intent(this,RoomDatabaseActivity::class.java)
            startActivity(intent)
        }

        binding.btnroomdatabase1.setOnClickListener {
            val intent = Intent(this, RoomDatabase1Activity::class.java)
            startActivity(intent)
        }

        binding.btnanimation.setOnClickListener {
            val intent = Intent(this,AnimationActivity::class.java)
            startActivity(intent)
        }

        binding.btntablayout.setOnClickListener {
            val intent = Intent(this,TabLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.expandablelistviewnavigationdrawer.setOnClickListener {
           val intent = Intent(this,Expandablelistviewnavigationdrawer::class.java)
            startActivity(intent)
        }

        binding.popup.setOnClickListener {
            val intent = Intent(this,PopupActivity::class.java)
            startActivity(intent)
        }

        binding.FloatingActionButton.setOnClickListener {
            val intent = Intent(this,ExtendedFloatingActionButtonActivity::class.java)
            startActivity(intent)
        }

        binding.navigationComponent.setOnClickListener {
            val intent = Intent(this, NavigationComponent::class.java)
            startActivity(intent)
        }

        binding.customnavigationDrawer.setOnClickListener {
            val intent = Intent(this,CustomNavigationDrawerActivity::class.java)
            startActivity(intent)
        }

        binding.carousel.setOnClickListener {
            val intent = Intent(this,CarouselActivity::class.java)
            startActivity(intent)
        }

        binding.btnwebview.setOnClickListener {
            val intent = Intent(this,WebViewAcivity::class.java)
            startActivity(intent)
        }

        binding.btnreadwrite.setOnClickListener {
            val intent = Intent(this,ReadAndWriteFile::class.java)
            startActivity(intent)
        }

        binding.btndrawbitmap.setOnClickListener {
            val intent = Intent(this,Bitmap::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Please confirm.")
            setMessage("Are you want to exit the app?")

            setPositiveButton("Yes") { _, _ ->
                // if user press yes, then finish the current activity
                super.onBackPressed()
            }

            setNegativeButton("No"){_, _ ->
                // if user press no, then return the activity
                Toast.makeText(this@MainActivity, "Thank you",
                    Toast.LENGTH_LONG).show()
            }

            setCancelable(true)
        }.create().show()
    }

}