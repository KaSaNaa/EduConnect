package com.retardeddev.educonnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.retardeddev.educonnect.data.SharedPrefHelper
import com.retardeddev.educonnect.navigation.AppNavHost
import com.retardeddev.educonnect.ui.theme.AppTheme
import com.retardeddev.educonnect.ui.theme.backgroundDark
import com.retardeddev.educonnect.viewModel.UserViewModel
import com.retardeddev.educonnect.viewModel.UserViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = backgroundDark,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    val sharedPrefHelper = SharedPrefHelper(this)
                    val factory = UserViewModelFactory(sharedPrefHelper)
                    val viewModel: UserViewModel = viewModel(factory = factory)
                    AppNavHost(navController = navController, sharedPrefHelper = sharedPrefHelper, viewModel = viewModel)
                }
            }
        }
    }
}