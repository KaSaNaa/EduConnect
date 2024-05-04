package com.retardeddev.educonnect.viewModel

import androidx.lifecycle.ViewModel
import com.retardeddev.educonnect.api.UserApi
import com.retardeddev.educonnect.data.SharedPrefHelper
import com.retardeddev.educonnect.data.repository.UserRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(private val sharedPrefHelper: SharedPrefHelper) : ViewModel() {
    private val userRepository = UserRepository()

    fun login(email: String, code: String) {
        userRepository.login(email, code).enqueue(object : Callback<UserApi.LoginResponse> {
            override fun onResponse(
                call: Call<UserApi.LoginResponse>,
                response: Response<UserApi.LoginResponse>
            ) {
                if (response.isSuccessful) {
                    val token = response.body()?.token
                    if (token != null) {
                        sharedPrefHelper.saveToken(token)
                        getUserData(token)
                    }
                } else {
                    // Handle unsuccessful response
                    println("Login failed: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<UserApi.LoginResponse>, t: Throwable) {
                // Handle failure
                println("Login request failed: ${t.message}")
            }
        })
    }

    fun getUserData(token: String) {
        userRepository.getUserData(token).enqueue(object : Callback<UserApi.UserDataResponse> {
            override fun onResponse(
                call: Call<UserApi.UserDataResponse>,
                response: Response<UserApi.UserDataResponse>
            ) {
                if (response.isSuccessful) {
                    val userData = response.body()?.toString()
                    if (userData != null) {
                        sharedPrefHelper.saveUserData(userData)
                    }
                } else {
                    println("Failed to retrieve user data: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<UserApi.UserDataResponse>, t: Throwable) {
                // Handle failure
                println("User data request failed: ${t.message}")
            }
        })
    }

    fun sendCode(email: String) {
        userRepository.sendCode(email).enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.isSuccessful) {
                    // Handle successful response
                    println("Code sent successfully")
                } else {
                    // Handle unsuccessful response
                    val errorBody = response.errorBody()?.string()
                    println("Failed to send code: $errorBody")
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                // Handle failure
                println("Send code request failed: ${t.message}")
                t.printStackTrace()
            }
        })
    }

    fun logout() {
        // Clear the saved data
        sharedPrefHelper.clearData()
    }
}

