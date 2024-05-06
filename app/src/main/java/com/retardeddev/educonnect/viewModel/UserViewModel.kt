package com.retardeddev.educonnect.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.retardeddev.educonnect.api.UserApi
import com.retardeddev.educonnect.data.SharedPrefHelper
import com.retardeddev.educonnect.data.model.Course
import com.retardeddev.educonnect.data.model.Notification
import com.retardeddev.educonnect.data.repository.DatabaseHelper
import com.retardeddev.educonnect.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class UserViewModel(private val sharedPrefHelper: SharedPrefHelper, private val context: Context) : ViewModel() {
    val courses = MutableLiveData<List<Course>>()
    private val userRepository = UserRepository()
    private val databaseHelper = DatabaseHelper(context)
    private val _courseDetails = MutableStateFlow<Course?>(null)
    val courseDetails: StateFlow<Course?> = _courseDetails

    fun signup(request: UserApi.SignupRequest) {
        viewModelScope.launch {
            val isSignupSuccessful = userRepository.signup(request)
            if (isSignupSuccessful) {
                // Handle successful signup
            } else {
                // Handle failed signup
            }
        }
    }

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
                    val gson = Gson()
                    val userDataJson = gson.toJson(userData)
                    sharedPrefHelper.saveUserData(userDataJson)
                    Log.d("UserViewModel", "User data: $userDataJson")
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

    val notifications = MutableLiveData<List<Notification>>()
    private val oldCourses = mutableListOf<Course>()

    fun fetchCourses() {
        viewModelScope.launch {
            try {
                val courseList = withContext(Dispatchers.IO) { userRepository.getCourses() }
                courses.value = courseList ?: emptyList()
                // Rest of the code remains the same...
            } catch (e: Exception) {
                println("Failed to fetch courses: ${e.message}")
            }
        }
    }

    fun getCourseDetails(courseId: Int) {
        viewModelScope.launch {
            try {
                val course = withContext(Dispatchers.IO) { userRepository.getCourseById(courseId) }
                _courseDetails.value = course
            } catch (e: Exception) {
                println("Failed to fetch course details: ${e.message}")
            }
        }
    }

    private fun addNotification(message: String) {
        val time = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        val notification = Notification(0, time, message)
        databaseHelper.addNotification(notification)
        val notificationList = databaseHelper.getNotifications()
        notifications.value = notificationList
    }
}