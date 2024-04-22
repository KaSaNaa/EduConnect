package com.retardeddev.educonnect.ui.components.courses

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.onSurfaceDark
import com.retardeddev.educonnect.ui.theme.surfaceDark


@Composable
fun CourseCardsList(courses: List<String>) {
    // Use a LazyVerticalGrid for efficient scrolling with large lists
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // This creates a grid with 2 columns
        contentPadding = PaddingValues(10.dp)
    ) {
        items(courses.size) { index ->
            CourseCard(courseName = courses[index])
        }
    }
}

@Preview
@Composable
private fun ListPreview() {
    val courseList = listOf("Software", "Hardware", "Network", "System Design", "Language", "Logistics")
    CourseCardsList(courses = courseList)
}



@Composable
private fun CourseCard(courseName: String) { // TODO: pass Course Objects
    OutlinedCard(
        onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(surfaceDark),
        modifier = Modifier.size(181.dp).padding(8.dp)
    ) {
        Column(modifier = Modifier.size(181.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                contentScale = ContentScale.Crop, // Use ContentScale.Crop to maintain aspect ratio
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // This makes the image take up half the space of the Column
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 15.dp, start = 8.dp)// This makes the texts take up the other half of the Column
            ) {
                Text(
                    text = courseName,
                    color = onSurfaceDark,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Subhead",
                    color = onSurfaceDark,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}