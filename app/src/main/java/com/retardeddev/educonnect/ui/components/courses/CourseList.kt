package com.retardeddev.educonnect.ui.components.courses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.onSurfaceDark
import com.retardeddev.educonnect.ui.theme.surfaceDark

@Preview
@Composable
private fun CourseCards() {

}

@Preview
@Composable
private fun CourseCard() {
    OutlinedCard(
        onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(surfaceDark),
        modifier = Modifier.size(181.dp)
    ) {
        Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null
                )
            }
            Row {
                Column {
                    Text(
                        text = "Header",
                        color = onSurfaceDark,
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = "Subheader",
                        color = onSurfaceDark,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Description",
                        color = onSurfaceDark,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}