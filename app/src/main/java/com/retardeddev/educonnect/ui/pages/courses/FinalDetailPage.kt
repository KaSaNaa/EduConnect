package com.retardeddev.educonnect.ui.pages.courses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.data.repository.DatabaseHelper
import com.retardeddev.educonnect.ui.components.courses.ButtonColumn
import com.retardeddev.educonnect.ui.components.courses.MyText
import com.retardeddev.educonnect.ui.components.courses.Text1
import com.retardeddev.educonnect.ui.components.courses.Text2
import com.retardeddev.educonnect.ui.components.courses.Text3
import com.retardeddev.educonnect.ui.components.courses.Text4
import com.retardeddev.educonnect.ui.components.courses.Text5
import com.retardeddev.educonnect.ui.components.courses.Text6
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight

@Composable
fun FinalDetailPage(databaseHelper: DatabaseHelper, courseID: Int) {
    val course = remember { mutableStateOf(databaseHelper.getCourseDetails(courseID)) }

    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(412.dp)
            .height(768.dp)
            .background(onSecondaryContainerLight)
    ) {
        MyText(course.value.desc)
        Text1(course.value.commencementDate)
        Text2(course.value.duration)
        Text3(course.value.fee)
        Text4(course.value.maxParticipants)
        Text5(course.value.branches)
        Text6(course.value.registrationClosingDate)
        ButtonColumn()
    }
}