package com.retardeddev.educonnect.ui.components.courses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight

@Preview
@Composable
fun ButtonColumn() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(0.dp, 50.dp, 0.dp, 0.dp),
        modifier = Modifier
            .width(412.dp)
            .height(768.dp)
            .background(onSecondaryContainerLight)
    ) {
        item {
            OutlinedButtonWithIcon1(onClick ={/*TODO*/})
        }
        item {
            FilledButton1(onClick ={/*TODO*/})
        }
    }
}