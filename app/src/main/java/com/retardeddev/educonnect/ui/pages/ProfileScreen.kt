package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.components.profile.AccountManagement
import com.retardeddev.educonnect.ui.components.profile.PersonalInfo
import com.retardeddev.educonnect.ui.components.profile.ProfilePicture
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal

@Preview
@Composable
fun ProfileScreen() {
    val scrollState = rememberScrollState()
    ColumnGlobal(
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        ProfilePicture()
        Spacer(modifier = Modifier.height(16.dp))
        PersonalInfo()
        Spacer(modifier = Modifier.height(16.dp))
        AccountManagement()
    }
}