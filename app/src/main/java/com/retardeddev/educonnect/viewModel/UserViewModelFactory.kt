package com.retardeddev.educonnect.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.retardeddev.educonnect.data.SharedPrefHelper

class UserViewModelFactory(private val sharedPrefHelper: SharedPrefHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(sharedPrefHelper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}