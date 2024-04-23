package com.retardeddev.educonnect.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.retardeddev.educonnect.navigation.NavigationItem
import com.retardeddev.educonnect.ui.theme.onSurfaceVariantDark
import com.retardeddev.educonnect.ui.theme.surfaceContainerDark


@Composable
fun BottomBar(navController: NavController) {
    BottomAppBar(
        containerColor = surfaceContainerDark,
        contentColor = contentColorFor(surfaceContainerDark),
    ){
        val iconColor = onSurfaceVariantDark
        Row(
            Modifier.fillMaxWidth(), // This makes the Row take up the full width of the BottomAppBar
            horizontalArrangement = Arrangement.SpaceBetween, // This places the maximum space possible between each IconButton
            verticalAlignment = Alignment.CenterVertically
        ){
            IconButton(onClick = { navController.navigate(NavigationItem.Home.route) }, modifier = Modifier.weight(1f)) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                    tint = iconColor,
                    modifier = Modifier.fillMaxSize(0.8f)
                )
            }
            IconButton(onClick = { navController.navigate(NavigationItem.Updates.route) }, modifier = Modifier.weight(1f)) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Updates",
                    tint = iconColor,
                    modifier = Modifier.fillMaxSize(0.8f)
                )
            }
            IconButton(onClick = { navController.navigate(NavigationItem.Profile.route) }, modifier = Modifier.weight(1f)) {
                Icon(
                    imageVector = Icons.Outlined.AccountCircle,
                    contentDescription = "Profile",
                    tint = iconColor,
                    modifier = Modifier.fillMaxSize(0.8f)
                )
            }
        }
    }
}