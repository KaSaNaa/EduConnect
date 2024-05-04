package com.retardeddev.educonnect.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.retardeddev.educonnect.api.UserApi
import com.retardeddev.educonnect.data.SharedPrefHelper
import com.retardeddev.educonnect.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val sharedPrefHelper: SharedPrefHelper) : ViewModel() {
    val courses = MutableLiveData<List<String>>()
    private val userRepository = UserRepository()

    fun login(email: String, code: String) {
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) { userRepository.login(email, code) }
                if (response != null) {
                    println("Login successful")
                    val token = response.token
                    sharedPrefHelper.saveToken(token)
                    getUserData(token)
                } else {
                    println("Login failed")
                }
            } catch (e: Exception) {
                println("Login request failed: ${e.message}")
            }
        }
    }

    private fun getUserData(token: String) {
        viewModelScope.launch {
            try {
                val userData = withContext(Dispatchers.IO) { userRepository.getUserData(token) }
                if (userData != null) {
                    if (userData is UserApi.UserDataResponse) {
                        val gson = Gson()
                        val userDataJson = gson.toJson(userData)
                        sharedPrefHelper.saveUserData(userDataJson)
                        Log.d("UserViewModel", "User data: $userDataJson")
                    } else {
                        println("Unexpected type: ${userData::class.java.name}")
                    }
                } else {
                    println("Failed to retrieve user data")
                }
            } catch (e: Exception) {
                println("User data request failed: ${e.message}")
            }
        }
    }

    fun sendCode(email: String) {
        viewModelScope.launch {
            try {
                val isCodeSent = withContext(Dispatchers.IO) { userRepository.sendCode(email) }
                if (isCodeSent) {
                    println("Code sent successfully")
                } else {
                    println("Failed to send code")
                }
            } catch (e: Exception) {
                println("Send code request failed: ${e.message}")
                e.printStackTrace()
            }
        }
    }

    fun logout() {
        sharedPrefHelper.clearData()
    }

    fun fetchCourses() {
    viewModelScope.launch {
        try {
            val courseList = withContext(Dispatchers.IO) { userRepository.getCourses() }
            courses.value = courseList?.map { it.title } ?: emptyList()
        } catch (e: Exception) {
            println("Failed to fetch courses: ${e.message}")
        }
    }
}
}