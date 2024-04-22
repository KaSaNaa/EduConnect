package com.retardeddev.educonnect.ui.pages.courses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.components.courses.CourseDetailButton
import com.retardeddev.educonnect.ui.components.courses.CourseDetailText
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal

@Preview
@Composable
fun CourseDetailsScreen() {
//    val course = remember { mutableStateOf(databaseHelper.getCourseDetails(courseID)) }

    ColumnGlobal(
        verticalArrangement = Arrangement.spacedBy(50.dp, Alignment.Top)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically),
            modifier = Modifier.padding(start = 15.dp, top = 30.dp)){
            CourseDetailText("Commencement", "This is good")
            CourseDetailText("Duration", "6 months")
            CourseDetailText("Fee", "2500 LKR")
            CourseDetailText("Maximum Participants", "75")
            CourseDetailText("Branches", "Colombo")
            CourseDetailText("Registration closing date", "April 1st 2001")
        }
        CourseDetailButton(
            onClick = {/*TODO*/ },
            icon = Icons.Filled.DateRange,
            text = "Find nearest branch"
        )
        CourseDetailButton(onClick = {/*TODO*/ }, icon = Icons.Filled.Check, text = "Register Now")
    }
}