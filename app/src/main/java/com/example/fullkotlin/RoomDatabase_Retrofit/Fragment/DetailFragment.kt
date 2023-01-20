package com.example.fullkotlin.RoomDatabase_Retrofit.Fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fullkotlin.R
import com.example.fullkotlin.RoomDatabase_Retrofit.viewModel.LocalUserViewModel
import com.example.fullkotlin.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

//    private val args by navArgs<DetailFragment>()
    private lateinit var mLocalUserViewModel: LocalUserViewModel
    private var binding: FragmentDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        binding?.deleteBtn?.setOnClickListener {
            deleteUser()
        }
        // Inflate the layout for this fragment
        return view
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
//        builder.setPositiveButton("Yes"){ _,_->
//            mLocalUserViewModel.deleteUser(args.currentUser)
//            Toast.makeText(requireContext(),"Successfully removed: ${args.currentUser.login}",Toast.LENGTH_SHORT).show()
//            findNavController().navigate(R.id.action_detailFragment_to_homeFragment)
//        }

        builder.setNegativeButton("No"){_,_->

        }
//        builder.setTitle("Delete ${args.currentUser.login}?")
        builder.setMessage("Are you sure you want to delete")
        builder.create().show()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {


            }
    }
}