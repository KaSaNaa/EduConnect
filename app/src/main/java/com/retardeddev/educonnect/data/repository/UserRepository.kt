package com.retardeddev.educonnect.data.repository

import com.retardeddev.educonnect.api.UserApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserRepository {
    private val userApi: UserApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/user/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        userApi = retrofit.create(UserApi::class.java)
    }

    fun login(email: String, code:String) : Call<UserApi.LoginResponse> {
        val request = UserApi.LoginRequest(email, code)
        return userApi.login(request)
    }

    fun sendCode(email: String) : Call<Unit> {
        val request = UserApi.LoginRequest(email, "")
        return userApi.sendCode(request)
    }
}