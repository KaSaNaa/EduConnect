package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.retardeddev.educonnect.data.SharedPrefHelper
import com.retardeddev.educonnect.ui.components.home.CoursesCarousel
import com.retardeddev.educonnect.ui.components.home.RecentUpdates
import com.retardeddev.educonnect.ui.components.home.WelcomeCard
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal
import com.retardeddev.educonnect.viewModel.UserViewModel

@Composable
fun HomeScreen(navController: NavController, sharedPrefHelper: SharedPrefHelper, viewModel: UserViewModel) {
    val userFullName = sharedPrefHelper.getUserFullName()
    val courses by viewModel.courses.observeAsState(emptyList())

    ColumnGlobal(
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically)
    ) {
        WelcomeCard(name = userFullName ?: "User")
        CoursesCarousel(navController, courses)
        val dummyUpdates = listOf("Update 1", "Update 2", "Update 3")
        RecentUpdates(dummyUpdates)
    }
}