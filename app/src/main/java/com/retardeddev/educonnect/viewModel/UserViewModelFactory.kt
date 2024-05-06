package com.retardeddev.educonnect.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.retardeddev.educonnect.data.SharedPrefHelper

class UserViewModelFactory(private val context: Context, private val sharedPrefHelper: SharedPrefHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(sharedPrefHelper, context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}