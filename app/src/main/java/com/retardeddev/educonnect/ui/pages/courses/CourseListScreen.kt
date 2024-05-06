package com.retardeddev.educonnect.ui.pages.courses

import androidx.compose.foundation.clickable
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.retardeddev.educonnect.ui.components.courses.CourseCardsList
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal
import com.retardeddev.educonnect.viewModel.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun CourseListScreen(viewModel: UserViewModel, navController: NavController) {
    val courses by viewModel.courses.observeAsState(emptyList())
    val notifications by viewModel.notifications.observeAsState(emptyList())
    viewModel.fetchCourses()

    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    notifications.forEach { notification ->
        coroutineScope.launch {
            snackBarHostState.showSnackbar(
                message = notification.message,
                actionLabel = "DISMISS",
                duration = SnackbarDuration.Indefinite
            )
        }
    }

    ColumnGlobal {
        CourseCardsList(courses = courses, navController = navController)
        SnackbarHost(hostState = snackBarHostState) { data ->
            Snackbar(snackbarData = data,
                actionOnNewLine = true,
                modifier = Modifier.clickable { snackBarHostState.currentSnackbarData?.dismiss() })
        }
    }
}