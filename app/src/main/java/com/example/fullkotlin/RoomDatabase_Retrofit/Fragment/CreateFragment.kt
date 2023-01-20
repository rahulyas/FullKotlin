package com.example.fullkotlin.RoomDatabase_Retrofit.Fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.fullkotlin.R
import com.example.fullkotlin.RoomDatabase_Retrofit.Model.User
import com.example.fullkotlin.RoomDatabase_Retrofit.viewModel.LocalUserViewModel
import com.example.fullkotlin.databinding.FragmentCreateBinding

class CreateFragment : Fragment() {

    private var binding: FragmentCreateBinding? = null
    private lateinit var mLocalUserViewModel: LocalUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        mLocalUserViewModel = ViewModelProvider(this).get(LocalUserViewModel::class.java)

        val view = inflater.inflate(R.layout.fragment_create, container, false)
        // Inflate the layout for this fragment
        val createButton = view.findViewById<Button>(R.id.create_button)

        createButton.setOnClickListener {
            addDataToDatabase()
        }
        return view;
    }

    private fun addDataToDatabase() {
        val name = binding?.CreateName?.text.toString()
        val type = binding?.CreateType?.text.toString()
        val avatarUrl = "https://avatars.githubusercontent.com/u/3?v=4"

        if (inputCheck(name, type)) {
            val user = User(0, name, type, avatarUrl)

            mLocalUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Added $name", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_createFragment_to_homeFragment)

        } else {
            Toast.makeText(requireContext(), "Please Add all the Data", Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(Name: String, Type: String): Boolean {
        return !(TextUtils.isEmpty(Name) && TextUtils.isEmpty(Type))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


    companion object {

        @JvmStatic fun newInstance(param1: String, param2: String) =
                CreateFragment().apply {

                }
    }

}