package com.retardeddev.educonnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.retardeddev.educonnect.data.repository.DatabaseHelper
import com.retardeddev.educonnect.ui.pages.courses.FinalDetailPage
import com.retardeddev.educonnect.ui.theme.AppTheme
import com.retardeddev.educonnect.ui.theme.backgroundDark

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = backgroundDark,
                    modifier = Modifier.fillMaxSize()) {
                    val dbHelper = DatabaseHelper(this)
                    dbHelper.logAllCourses()
                    FinalDetailPage(dbHelper, 1)
                }
            }
        }
    }
}