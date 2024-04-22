package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.components.updates.UpdatesList
import com.retardeddev.educonnect.ui.pages.global.ColumnGlobal
import com.retardeddev.educonnect.ui.theme.onBackgroundDark

@Preview
@Composable
private fun UpdatesScreen() {
    ColumnGlobal(
        verticalArrangement = Arrangement.
        spacedBy(30.dp, Alignment.Top)
    ) {
        Row {
            Text(
                text = "Updates",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = Bold,
                color = onBackgroundDark,
                onTextLayout = {/*TODO*/ },
                modifier = Modifier
                    .weight(1f) // This will take up the remaining space
                    .padding(20.dp, 14.dp)
                    .align(Alignment.Top) // Align to center vertically
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 0.dp)
        ) {
            item {
                val updates = listOf("Update 1", "Update 2", "Update 3", "updates 2")
                UpdatesList(updates = updates)
            }
        }
    }
}