package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight
import com.retardeddev.educonnect.ui.theme.onSurfaceDark
import com.retardeddev.educonnect.ui.theme.onSurfaceVariantDark
import com.retardeddev.educonnect.ui.theme.outlineDark

@Preview
@Composable
private fun SignupForm() {
    Surface {
        Column(
            modifier = Modifier
                .width(412.dp)
                .height(892.dp)
                .background(onSecondaryContainerLight),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Image(
                painter = painterResource(id = R.drawable.logomain),
                contentDescription = null,
                modifier = Modifier
                    .width(94.03.dp)
                    .height(83.dp)
            )
            LazyColumn(modifier = Modifier
                .width(350.dp)
                .height(538.dp)
                .background(onSecondaryContainerLight)
                .border(1.dp, outlineDark, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                item {
                    CustomTextField(label = "Name", placeholder = "Enter your full name")
                    CustomSpacer()
                    CustomTextField(label = "Address", placeholder = "Enter your address")
                    CustomSpacer()
                    CustomTextField(label = "Living City", placeholder = "Enter your city")
                    CustomSpacer()
                    CustomTextField(label = "NIC Number", placeholder = "National Identity Card Number")
                    CustomSpacer()
                    CustomTextField(label = "Email", placeholder = "Enter a valid email address")
                    CustomSpacer()
                    CustomTextField(label = "Mobile", placeholder = "Mobile phone number")
                    CustomSpacer()
                }
            }
        }
    }
}
@Composable
fun CustomTextField(label: String, placeholder: String) {
    OutlinedTextField(
        value = "",
        onValueChange = { /* Handle text change */ },
        label = { Text(label, color = outlineDark) },
        placeholder = { Text(placeholder) },
        modifier = Modifier
            .width(316.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Close, // Wrong sign icon
                contentDescription = "Trailing icon",
                tint = onSurfaceVariantDark
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = outlineDark,
            focusedLabelColor = outlineDark,
            cursorColor = outlineDark
        )
    )
}

@Composable
fun CustomSpacer() {
    Spacer(modifier = Modifier.height(10.dp))
}

