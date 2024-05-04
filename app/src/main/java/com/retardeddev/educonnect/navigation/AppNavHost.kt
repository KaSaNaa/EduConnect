package com.retardeddev.educonnect.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.retardeddev.educonnect.data.SharedPrefHelper
import com.retardeddev.educonnect.ui.components.BottomBar
import com.retardeddev.educonnect.ui.pages.HomeScreen
import com.retardeddev.educonnect.ui.pages.LoginForm
import com.retardeddev.educonnect.ui.pages.ProfileScreen
import com.retardeddev.educonnect.ui.pages.SignupForm
import com.retardeddev.educonnect.ui.pages.SplashScreen
import com.retardeddev.educonnect.ui.pages.UpdatesScreen
import com.retardeddev.educonnect.ui.pages.courses.CourseListScreen
import com.retardeddev.educonnect.viewModel.UserViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    sharedPrefHelper: SharedPrefHelper,
    viewModel: UserViewModel, // Add this line
    startDestination: String = NavigationItem.Splash.route
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.Splash.route) {
            SplashScreen(navController)
        }
        composable(NavigationItem.Signin.route) {
            LoginForm(navController, sharedPrefHelper)
        }
        composable(NavigationItem.Signup.route) {
            SignupForm()
        }
        composable(NavigationItem.Home.route) {
            ScreenWithBottomBar(navController) {
                HomeScreen(navController, sharedPrefHelper, viewModel)
            }
        }
        composable(NavigationItem.CourseList.route) {
            ScreenWithBottomBar(navController) {
                CourseListScreen()
            }
        }
        composable(NavigationItem.Profile.route) {
            ScreenWithBottomBar(navController) {
                ProfileScreen(sharedPrefHelper)
            }
        }
        composable(NavigationItem.Updates.route) {
            ScreenWithBottomBar(navController) {
                UpdatesScreen()
            }
        }
    }
}

@Composable
fun ScreenWithBottomBar(navController: NavController, screenContent: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        screenContent()
        BottomBar(navController = navController)
    }
}