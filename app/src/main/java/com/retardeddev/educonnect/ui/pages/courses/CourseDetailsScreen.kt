package com.retardeddev.educonnect.ui.pages.courses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.components.courses.CourseDetailButton
import com.retardeddev.educonnect.ui.components.courses.CourseDetailText
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal
import com.retardeddev.educonnect.viewModel.UserViewModel

@Composable
fun CourseDetailsScreen(courseId: Int, viewModel: UserViewModel) {
    viewModel.getCourseDetails(courseId)
    val course by viewModel.courseDetails.collectAsState()

    ColumnGlobal(
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically),
        modifier = Modifier.padding(start = 15.dp, top = 30.dp)
    ) {
        CourseDetailText("Title", course?.title ?: "")
        CourseDetailText("Description", course?.description ?: "")
        CourseDetailText("Commencement", course?.commencement ?: "")
        CourseDetailText("Duration", course?.duration ?: "")
        CourseDetailText("Fee", course?.fee ?: "")
        CourseDetailText("Maximum Participants", course?.maxParticipants.toString() ?: "")
        CourseDetailText("Branches", course?.branches?.joinToString() ?: "")
        CourseDetailText("Registration closing date", "April 1st 2001")

        CourseDetailButton(onClick = {/*TODO*/ }, icon = Icons.Filled.DateRange, text = "Find nearest branch")
        CourseDetailButton(onClick = {/*TODO*/ }, icon = Icons.Filled.Check, text = "Register Now")
    }
}

@Preview
@Composable
private fun btnprev() {
    CourseDetailButton(onClick = {/*TODO*/ }, icon = Icons.Filled.Check, text = "Register Now")
}