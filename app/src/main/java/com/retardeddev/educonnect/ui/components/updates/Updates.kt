package com.retardeddev.educonnect.ui.components.updates

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.theme.onBackgroundDark
import com.retardeddev.educonnect.ui.theme.onSecondaryDark
import com.retardeddev.educonnect.ui.theme.secondaryDark

@Composable
fun UpdatesList(updates: List<String>) {
    Column(modifier = Modifier.padding(20.dp, 5.dp)) {
        Box(modifier = Modifier.padding(10.dp)) {
            Column {
                Card(
                    colors = CardDefaults.cardColors(onSecondaryDark),
                ) {
                    updates.forEach { update ->
                        ListItem(
                            headlineContent = {
                                Text(
                                    update,
                                    onTextLayout = {/*TODO*/ },
                                    color = secondaryDark
                                )
                            },
                            leadingContent = {
                                Icon(
                                    Icons.Filled.Info,
                                    contentDescription = "Update",
                                    tint = onBackgroundDark
                                )
                            },
                            colors = ListItemDefaults.colors(onSecondaryDark)
                        )
                        Divider()
                    }
                }
            }
        }
    }
}

