package com.example.fullkotlin.RoomDatabase_Retrofit.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fullkotlin.RoomDatabase_Retrofit.Model.User
import com.example.fullkotlin.RoomDatabase_Retrofit.Repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    val myResponse: MutableLiveData<Response<List<User>>> = MutableLiveData()

//    fun getUser() {
//        viewModelScope.launch {
//            val response = repository.getUser()
//            myResponse.value = response
//
//        }
//    }

}