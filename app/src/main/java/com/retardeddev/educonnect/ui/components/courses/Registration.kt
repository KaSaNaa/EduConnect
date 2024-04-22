package com.retardeddev.educonnect.ui.components.courses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardeddev.educonnect.ui.theme.onBackgroundDark
import com.retardeddev.educonnect.ui.theme.onSecondaryDark


@Preview
@Composable
fun Name() {
    var text by remember { mutableStateOf("Enter your full name") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(color = Color.White),
        label = { Text("Name", color = Color.White, onTextLayout = {/*TODO*/ }) },
        trailingIcon = {
            if (text.isNotEmpty()) { // Show icon only when text is present
                IconButton(onClick = { text = "" }) { // Clear text on click
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear name",
                        tint = Color.White
                    )
                }
            }
        }

    )
}

@Preview
@Composable
fun Address() {
    var text by remember { mutableStateOf("Enter you address") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(color = Color.White),
        label = { Text("Address", color = Color.White, onTextLayout = {/*TODO*/ }) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Clear address",
                tint = Color.White
            )
        }
    )
}

@Preview
@Composable
fun City() {
    var text by remember { mutableStateOf("City") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(color = Color.White),
        label = { Text("City", color = Color.White, onTextLayout = {/*TODO*/ }) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Clear city",
                tint = Color.White
            )
        }
    )
}


@Preview
@Composable
fun NIC() {
    var text by remember { mutableStateOf("National Identity Card Number") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(color = Color.White),
        label = { Text("NIC Number", color = Color.White, onTextLayout = {/*TODO*/ }) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Clear NIC",
                tint = Color.White
            )
        }
    )
}


@Preview
@Composable
fun Email() {
    var text by remember { mutableStateOf("Enter a valid email address") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(color = Color.White),
        label = { Text("E-mail", color = Color.White, onTextLayout = {/*TODO*/ }) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Clear e-mail",
                tint = Color.White
            )
        }
    )
}


@Composable
fun Mobile() {
    var text by remember { mutableStateOf("Mobile phone number") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(color = Color.White),
        label = { Text("Mobile", color = Color.White, onTextLayout = {/*TODO*/ }) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Clear mobile phone number",
                tint = Color.White
            )
        }
    )
}

@Composable
fun MobileEx() {
    Text(
        text = "Ex: +94771234567",
        color = Color.White,
        onTextLayout = {/*TODO*/ }
    )

}

@Preview
@Composable
fun MobilePrint() {
    Column {
        Mobile()
        MobileEx()
    }
}

@Preview
@Composable
private fun RadioPrev1() {
    GenderPrint()
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DatePickerPrev() {
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 0)
    DatePicker(state = datePickerState,
        modifier = Modifier
        .padding(16.dp) // Maintain existing padding
        .background(Color.DarkGray)
            )

    Text("Date of birthday ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp)
}


@Preview
@Composable
private fun RadioPrev2() {
    CoursePrint()
}

@Preview
@Composable
private fun RadioPrev3() {
    BranchPrint()
}


@Composable
fun OutlinedButtonWithIcon() {
    OutlinedButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.outlinedButtonColors(onSecondaryDark),
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .height(48.dp)
            .width(192.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(11.dp) // Adjust this value to your preference
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowForward, // Replace with your own icon
                contentDescription = "Icon description", // Accessibility description
                tint = onBackgroundDark,
                modifier = Modifier.padding(3.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                "Apply Promo Code",
                color = onBackgroundDark,
                onTextLayout = {/*TODO*/ },
                fontSize = MaterialTheme.typography.labelMedium.fontSize
            )
        }
    }
}

@Preview
@Composable
private fun PreviewButton() {
    OutlinedButtonWithIcon()
}

@Composable
fun FilledButton() {
    Button(
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier
            .height(40.dp)
            .width(120.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(9.dp) // Adjust this value to your preference
        ) {
            Icon(
                imageVector = Icons.Outlined.Check, // Replace with your own icon
                contentDescription = "Icon description", // Accessibility description
                tint = onBackgroundDark,
                modifier = Modifier.padding(3.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                "Register",
                color = onBackgroundDark,
                onTextLayout = {/*TODO*/ },
                fontSize = MaterialTheme.typography.labelMedium.fontSize
            )
        }
    }
}

@Preview
@Composable
private fun PreviewButton1() {
    FilledButton()
}

