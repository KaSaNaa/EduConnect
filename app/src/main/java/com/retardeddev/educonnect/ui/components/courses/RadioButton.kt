package com.retardeddev.educonnect.ui.components.courses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.theme.onBackgroundDark


@Composable
fun  RadioButtonPrev(){
    val radioOptions = listOf("Male", "Female")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(35.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    color = onBackgroundDark,
                    modifier = Modifier.padding(start = 16.dp),
                    onTextLayout = {/*TODO*/},
                )
            }
        }
    }
}

@Composable
fun Gender() {
    Text(
        text = "Gender",
        color = Color.White,
        onTextLayout = {/*TODO*/}
    )

}

@Preview
@Composable
fun GenderPrint() {
    Column {
        Gender()
        RadioButtonPrev()
    }
}

@Composable
fun  RadioButtonPrev1(){
    val radioOptions = listOf("Full-time", "Part-time")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(35.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    color = onBackgroundDark,
                    modifier = Modifier.padding(start = 16.dp),
                    onTextLayout = {/*TODO*/},
                )
            }
        }
    }
}

@Composable
fun Course() {
    Text(
        text = "Course Commitment",
        color = Color.White,
        onTextLayout = {/*TODO*/}
    )

}

@Preview
@Composable
fun CoursePrint() {
    Column {
        Course()
        RadioButtonPrev1()
    }
}

@Composable
fun  RadioButtonPrev2(){
    val radioOptions = listOf("Colombo", "Kandy", "Matara")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(35.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge,
                    color = onBackgroundDark,
                    modifier = Modifier.padding(start = 16.dp),
                    onTextLayout = {/*TODO*/},
                )
            }
        }
    }
}

@Composable
fun Branch() {
    Text(
        text = "Course Commitment",
        color = Color.White,
        onTextLayout = {/*TODO*/}
    )

}

@Preview
@Composable
fun BranchPrint() {
    Column {
        Branch()
        RadioButtonPrev2()
    }
}