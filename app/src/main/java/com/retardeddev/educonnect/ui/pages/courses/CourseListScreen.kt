package com.retardeddev.educonnect.ui.pages.courses

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.retardeddev.educonnect.ui.components.courses.CourseCardsList
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal
import com.retardeddev.educonnect.viewModel.UserViewModel

@Composable
fun CourseListScreen(viewModel: UserViewModel) {
    val courses by viewModel.courses.observeAsState(emptyList())
    viewModel.fetchCourses()

    ColumnGlobal {
        CourseCardsList(courses = courses)
    }
}