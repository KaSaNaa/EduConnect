package com.retardeddev.educonnect.data

import UserApi
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

class SharedPrefHelper(context: Context) {
    private val PREFS_NAME = "user_prefs"
    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        val editor = prefs.edit()
        editor.putString("token", token)
        editor.apply()
    }

    fun getUserFullName(): String {
        val userDataJson = prefs.getString("userData", "")
        if (!userDataJson.isNullOrEmpty()) {
            val gson = Gson()
            try {
                val userData =
                    gson.fromJson(userDataJson, UserApi.UserDataResponse::class.javaObjectType)
                return userData.fullName
            } catch (e: JsonSyntaxException) {
                println("Failed to parse user data JSON: ${e.message}")
            }
        }
        return ""
    }

    fun getToken(): String? {
        return prefs.getString("token", null)
    }

    fun saveUserData(userData: String) {
        val editor = prefs.edit()
        editor.putString("userData", userData)
        editor.apply()
    }

    fun getUserData(): String? {
        return prefs.getString("userData", null)
    }

    fun clearData() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}