package com.retardeddev.educonnect.ui.components.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight


@Preview
@Composable
private fun LoginForm() {
    Surface {
        Column(
            modifier = Modifier
                .width(412.dp)
                .height(892.dp)
                .background(onSecondaryContainerLight) ,

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
        )
       {
                Image(painter = painterResource(id = R.drawable.logomain),
                    contentDescription = null,
                    modifier = Modifier
                        .width(137.07381.dp)
                        .height(121.dp)
                )
           var text by remember { mutableStateOf("") }
           OutlinedTextField(value = text,
               onValueChange = { text = it },
               label = { Text("Email") },
               placeholder = { Text("Enter your email") },
               modifier = Modifier
                   .padding(0.dp)
                   .width(275.dp)
                   .height(56.dp),
               trailingIcon = { Icon(Icons.Filled.Email, contentDescription = "Localized description")

               }
           )
       }
    }
}