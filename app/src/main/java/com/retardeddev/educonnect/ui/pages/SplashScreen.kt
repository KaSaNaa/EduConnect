package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.navigation.NavigationItem
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    // Launch a coroutine to delay for a certain time, then navigate to the home screen
    LaunchedEffect(Unit) {
        delay(3000) // delay for 3 seconds
        navController.navigate(NavigationItem.Home.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
            // Avoid multiple copies of the same destination when
            // re-selecting the same item
            launchSingleTop = true
        }
    }
    Surface {
        Column(
            modifier = Modifier
                .width(412.dp)
                .height(892.dp)
                .background(onSecondaryContainerLight),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.logomain),
                contentDescription = null,
                modifier = Modifier
                    .width(137.07381.dp)
                    .height(121.dp)
            )
        }
    }
}