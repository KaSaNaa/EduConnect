package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight


@Preview
@Composable
fun SplashScreen() {
    Surface {
        Column(
            modifier = Modifier
                .width(412.dp)
                .height(892.dp)
                .background(onSecondaryContainerLight),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {
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