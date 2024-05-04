package com.retardeddev.educonnect.data

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper(context: Context) {
    private val PREFS_NAME = "user_prefs"
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        val editor = prefs.edit()
        editor.putString("token", token)
        editor.apply()
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