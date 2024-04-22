package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.components.home.CoursesCarousel
import com.retardeddev.educonnect.ui.components.home.RecentUpdates
import com.retardeddev.educonnect.ui.components.home.WelcomeCard
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal

@Preview
@Composable
fun HomeScreen() {
    ColumnGlobal(
        verticalArrangement = Arrangement.
            spacedBy(30.dp, Alignment.CenterVertically)
    ) {
        WelcomeCard(name = "Pasindu Ranawakage")
        CoursesCarousel()
        val dummyUpdates = listOf("Update 1", "Update 2", "Update 3")
        RecentUpdates(dummyUpdates)
    }
}