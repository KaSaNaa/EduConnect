package com.retardeddev.educonnect.ui.pages.courses

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.retardeddev.educonnect.ui.components.courses.CourseCardsList
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal

@Preview
@Composable
private fun CourseListScreen() {
    val courseList =
        listOf("Software", "Hardware", "Network", "System Design", "Language", "Logistics")
    ColumnGlobal {
        CourseCardsList(courses = courseList)
    }
}