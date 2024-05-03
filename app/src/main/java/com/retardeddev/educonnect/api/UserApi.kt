package com.retardeddev.educonnect.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    data class LoginRequest(val email: String, val code: String)
    data class LoginResponse(val token: String) // Adjust this based on the actual response

    @POST("/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("/send-code")
    fun sendCode(@Body request: LoginRequest): Call<Unit>

}