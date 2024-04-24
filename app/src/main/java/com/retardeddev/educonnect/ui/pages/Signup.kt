package com.retardeddev.educonnect.ui.pages

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.icu.util.Calendar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.inverseOnSurfaceLight
import com.retardeddev.educonnect.ui.theme.onPrimaryDark
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerDark
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight
import com.retardeddev.educonnect.ui.theme.onSurfaceDark
import com.retardeddev.educonnect.ui.theme.onSurfaceVariantDark
import com.retardeddev.educonnect.ui.theme.outlineDark
import com.retardeddev.educonnect.ui.theme.outlineVariantDark
import com.retardeddev.educonnect.ui.theme.primaryDark

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
                .border(1.dp, Color(0xFF4F378B), RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                item {
                    CustomSpacer1()
                    CustomTextField(label = "Name", placeholder = "Enter your full name")
                    CustomSpacer1()
                    CustomTextField(label = "Address", placeholder = "Enter your address")
                    CustomSpacer1()
                    CustomTextField(label = "Living City", placeholder = "Enter your city")
                    CustomSpacer1()
                    CustomTextField(label = "NIC Number", placeholder = "National Identity Card Number")
                    CustomSpacer1()
                    CustomTextField(label = "Email", placeholder = "Enter a valid email address")
                    CustomSpacer1()
                    CustomTextField(label = "Mobile", placeholder = "Mobile phone number")
                    CustomSpacer1()
                    GenderRadioButton()
                    CustomSpacer1()
                    val context = LocalContext.current
                    com.retardeddev.educonnect.ui.pages.DatePicker(context = context)
                    CustomSpacer1()
                }
            }
            CustomSpacer2()
            Button(
                onClick = { /*TODO: Handle click event*/ },
                modifier = Modifier
                    .width(148.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(primaryDark)
            )
            {Text("Sign up", color = onPrimaryDark)}

            CustomSpacer2()

            HorizontalDivider(
                modifier = Modifier
                    .width(320.dp)
                    .height(1.dp),
                color = outlineVariantDark
            )

            CustomSpacer2()

            Text(
                text = "Already have an account?",
                color = inverseOnSurfaceLight
            )

            CustomSpacer2()

            OutlinedButton(
                onClick = { /*TODO: Handle click event*/ },
                modifier = Modifier
                    .width(148.dp)
                    .height(40.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = outlineDark
                )
            )
            { Text("Sign in", color = primaryDark) }
        }
    }
}
@Composable
fun CustomTextField(label: String, placeholder: String) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = {text = it},
        label = { Text(label, color = outlineDark) },
        placeholder = { Text(placeholder) },
        modifier = Modifier
            .width(316.dp),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.Close, // Wrong sign icon
                contentDescription = "Trailing icon",
                tint = outlineDark
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = outlineDark,
            focusedLabelColor = outlineDark,
            cursorColor = outlineDark,
            focusedTextColor = onSurfaceVariantDark,
            unfocusedTextColor = outlineDark
        )
    )
}
@Composable
fun CustomSpacer1() {
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun CustomSpacer2(){
    Spacer(modifier = Modifier.height(16.dp))
}
@Composable
fun GenderRadioButton() {
    var selectedGender by remember { mutableStateOf("Male") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
    ) { // Add start padding here
        Text(text = "Gender", color = outlineDark)
        Row ()
        {
            RadioButton(
                selected = selectedGender == "Male",
                onClick = { selectedGender = "Male" },
            )
            Text("Male", Modifier.align(Alignment.CenterVertically), color = outlineDark)
            Spacer(Modifier.width(20.dp))
            RadioButton(
                selected = selectedGender == "Female",
                onClick = { selectedGender = "Female" },
            )
            Text("Female", Modifier.align(Alignment.CenterVertically), color = outlineDark)
        }
    }
}

@Composable
fun DatePicker(context: Context) {
    val focusRequester = remember { FocusRequester() }
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Date of Birth", color= outlineDark) },
        placeholder = { Text("MM/DD/YYYY") },
        modifier = Modifier
            .width(316.dp)
            .focusRequester(focusRequester),
        trailingIcon = {
            Icon(
                imageVector = Icons.Filled.DateRange, // Date picker icon
                contentDescription = "Date picker icon",
                tint = if (text.isNotEmpty()) outlineDark else onSurfaceVariantDark,
                modifier = Modifier.clickable {
                    val calendar = Calendar.getInstance()
                    val year = calendar.get(Calendar.YEAR)
                    val month = calendar.get(Calendar.MONTH)
                    val day = calendar.get(Calendar.DAY_OF_MONTH)
                    val dpd = DatePickerDialog(context, null, year, month, day)
                    dpd.datePicker.init(year, month, day, null)
                    dpd.setButton(DialogInterface.BUTTON_POSITIVE, "OK") { _, _ ->
                        val monthOfYear = dpd.datePicker.month
                        val dayOfMonth = dpd.datePicker.dayOfMonth
                        val year = dpd.datePicker.year
                        // Format the selected date and set it as the value of the text field
                        text = "${monthOfYear + 1}/$dayOfMonth/$year"
                        dpd.dismiss()
                        focusRequester.requestFocus()
                    }
                    dpd.show()
                }
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = outlineDark, // Change color when focused
            focusedLabelColor =  outlineDark,
            cursorColor = outlineDark,
            focusedTextColor = onSurfaceVariantDark,
            unfocusedTextColor = outlineDark
        )
    )
}


