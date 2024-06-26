package com.retardeddev.educonnect.api

import com.retardeddev.educonnect.data.model.Course
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {
    data class LoginRequest(val email: String, val code: String)
    data class LoginResponse(val token: String)
    data class SendCodeRequest(val email: String)
    data class UserDataResponse(
        val _id: String,
        val username: String,
        val fullName: String,
        val address: String,
        val city: String,
        val nic: String,
        val email: String,
        val phoneNumber: String,
        val gender: Boolean,
        val dob: String,
        val uid: Int,
        val __v: Int
    )

    data class SignupRequest(
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

    @POST("user/signup")
    suspend fun signup(@Body request: SignupRequest): Response<Unit>

    @POST("user/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("user/sendcode")
    suspend fun sendCode(@Body request: SendCodeRequest): Response<Unit>

    @GET("user")
    suspend fun getUserData(@Header("Authorization") token: String): Response<UserDataResponse>

    @GET("course")
    suspend fun getCourses(): Response<List<Course>>

    @GET("course/{id}")
    suspend fun getCoursebyId(@Path("id") id: Int): Response<Course>
}