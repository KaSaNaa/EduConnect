package com.retardeddev.educonnect.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UserApi {
    data class LoginRequest(val email: String, val code: String)
    data class LoginResponse(val token: String) // Adjust this based on the actual response
    data class SendCodeRequest(val email: String)
    data class UserDataResponse(
        val username: String,
        val fullName: String,
        val address: String,
        val city: String,
        val nic: String,
        val email: String,
        val phoneNumber: String,
        val gender: Boolean,
        val dob: String
    )
    @POST("user/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("user/sendcode")
    fun sendCode(@Body request: SendCodeRequest): Call<Unit>

    @GET("user")
    fun getUserData(@Header("Authorization") token: String): Call<UserDataResponse>
}