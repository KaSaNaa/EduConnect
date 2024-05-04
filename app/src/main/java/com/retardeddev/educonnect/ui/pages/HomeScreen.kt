package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.data.SharedPrefHelper
import com.retardeddev.educonnect.ui.components.home.CoursesCarousel
import com.retardeddev.educonnect.ui.components.home.RecentUpdates
import com.retardeddev.educonnect.ui.components.home.WelcomeCard
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal

@Composable
fun HomeScreen(sharedPrefHelper: SharedPrefHelper) {
    val userFullName = sharedPrefHelper.getUserFullName()
    ColumnGlobal(
        verticalArrangement = Arrangement.
            spacedBy(30.dp, Alignment.CenterVertically)
    ) {
        WelcomeCard(name = userFullName ?: "User")
        CoursesCarousel()
        val dummyUpdates = listOf("Update 1", "Update 2", "Update 3")
        RecentUpdates(dummyUpdates)
    }
}