package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.backgroundDark
import com.retardeddev.educonnect.ui.theme.inverseOnSurfaceLight
import com.retardeddev.educonnect.ui.theme.onBackgroundDark
import com.retardeddev.educonnect.ui.theme.onPrimaryContainerDark
import com.retardeddev.educonnect.ui.theme.onPrimaryDark
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerDark
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight
import com.retardeddev.educonnect.ui.theme.onSurfaceLight
import com.retardeddev.educonnect.ui.theme.onSurfaceVariantLight
import com.retardeddev.educonnect.ui.theme.outlineDark
import com.retardeddev.educonnect.ui.theme.outlineLight
import com.retardeddev.educonnect.ui.theme.outlineVariantDark
import com.retardeddev.educonnect.ui.theme.primaryDark
import com.retardeddev.educonnect.ui.theme.surfaceBrightDark
import com.retardeddev.educonnect.ui.theme.surfaceContainerHighestDark


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun LoginForm() {
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

            Spacer(modifier = Modifier.height(16.dp))

            var text1 by remember { mutableStateOf("") }
            OutlinedTextField(value = text1,
                onValueChange = { text1 = it },
                label = { Text("Email") },
                placeholder = { Text("Enter your Email")},

                modifier = Modifier
                    .width(275.dp),

                trailingIcon = {
                    Icon(
                        Icons.Filled.Email,
                        contentDescription = "email",
                        tint = onSecondaryContainerDark)
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = outlineDark,
                    focusedLabelColor = outlineDark,
                    cursorColor = outlineDark
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            var text2 by remember { mutableStateOf("") }
            OutlinedTextField(value = text2,
                onValueChange = { text2 = it },
                label = { Text("Verification Code") },
                placeholder = { Text("Enter the verification code")},

                modifier = Modifier
                    .width(275.dp),

                trailingIcon = {
                    Icon(
                        Icons.Outlined.Close,
                        contentDescription = "cancel",
                        tint = onSecondaryContainerDark
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = outlineDark,
                    focusedLabelColor = outlineDark,
                    cursorColor = outlineDark
                )
            )

           Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = { /*TODO: Handle click event*/ },
                modifier = Modifier
                    .width(148.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(primaryDark)
            )
            {Text("Sign In", color = onPrimaryDark)}

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "OR",
                color = inverseOnSurfaceLight
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /*TODO: Handle click event*/ },
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(surfaceContainerHighestDark)
            ) {
                Icon(
                    Icons.Default.AccountCircle,
                    contentDescription = "Profile Icon",
                    tint = primaryDark,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text("Guest", color = primaryDark)
            }

            Spacer(modifier = Modifier.height(25.dp)) // This adds space between the button and the divider

            HorizontalDivider(
                modifier = Modifier
                    .width(320.dp)
                    .height(1.dp),
                color = outlineVariantDark
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Don't have an account yet?",
                color = inverseOnSurfaceLight
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = { /*TODO: Handle click event*/ },
                modifier = Modifier
                    .width(148.dp)
                    .height(40.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = outlineDark
                )
            )
            { Text("Sign Up", color = primaryDark) }
        }
    }
}