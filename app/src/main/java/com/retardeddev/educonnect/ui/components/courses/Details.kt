package com.retardeddev.educonnect.ui.components.courses

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CourseDetailText(label: String, value: String) {
    Row(Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "$label:", color = Color.White, fontSize = 16.sp)
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(text = value, color = Color.White, fontSize = 16.sp)
        }
    }
}

@Composable
fun CourseDetailButton(onClick: () -> Unit, icon: ImageVector, text: String) {
    Button(onClick = onClick) {
        Row {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
            Text(text, fontSize = 14.sp, modifier = Modifier.padding(start = 8.dp))
        }
    }
}