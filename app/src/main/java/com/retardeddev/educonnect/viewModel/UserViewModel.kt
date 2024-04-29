package com.retardeddev.educonnect.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retardeddev.educonnect.data.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val userRepository = UserRepository()

    fun login(email: String, code: String) {
        viewModelScope.launch {
            val response = userRepository.login(email, code)
        }
    }
}