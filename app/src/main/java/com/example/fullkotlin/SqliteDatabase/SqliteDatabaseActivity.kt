package com.example.fullkotlin.SqliteDatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.example.fullkotlin.R
import com.example.fullkotlin.databinding.ActivitySqliteDatabaseBinding

class SqliteDatabaseActivity : AppCompatActivity() {

    lateinit var binding:ActivitySqliteDatabaseBinding
    lateinit var usersDBHelper : UsersDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySqliteDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usersDBHelper = UsersDBHelper(this)

    }

    fun addUser(v: View){
        var userid = this.binding.edittextUserid.text.toString()
        var name = this.binding.edittextName.text.toString()
        var age = this.binding.edittextAge.text.toString()
        var result = usersDBHelper.insertUser(UserModel(userid = userid,name = name,age = age))
        //clear all edittext s
        this.binding.edittextAge.setText("")
        this.binding.edittextName.setText("")
        this.binding.edittextUserid.setText("")
        this.binding.textviewResult.text = "Added user : "+result
        this.binding.llEntries.removeAllViews()
    }

    fun deleteUser(v:View){
        var userid = this.binding.edittextUserid.text.toString()
        val result = usersDBHelper.deleteUser(userid)
        this.binding.textviewResult.text = "Deleted user : "+result
        this.binding.llEntries.removeAllViews()
    }

    fun showAllUsers(v:View){
        var users = usersDBHelper.readAllUsers()
        this.binding.llEntries.removeAllViews()
        users.forEach {
            var tv_user = TextView(this)
            tv_user.textSize = 30F
            tv_user.text = it.userid.toString()+ " - " +it.name.toString() + " - " + it.age.toString()
            this.binding.llEntries.addView(tv_user)
        }
        this.binding.textviewResult.text = "Fetched " + users.size + " users"
    }
}