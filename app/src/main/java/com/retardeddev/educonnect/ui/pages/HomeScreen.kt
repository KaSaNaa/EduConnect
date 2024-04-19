package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.components.home.CoursesCarousel
import com.retardeddev.educonnect.ui.components.home.RecentUpdates
import com.retardeddev.educonnect.ui.components.home.WelcomeCard
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight

@Preview
@Composable
fun HomeScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(412.dp)
            .height(768.dp)
            .background(onSecondaryContainerLight)
    ) {
        WelcomeCard(name = "Pasindu Ranawakage")
        CoursesCarousel()
        val dummyUpdates = listOf("Update 1", "Update 2", "Update 3")
        RecentUpdates(dummyUpdates)
    }
}