package com.retardeddev.educonnect.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.R

@Composable
fun ImageCarousel(imageList: List<Int>) {
    LazyRow(modifier = Modifier.padding(horizontal = 16.dp)) {
        items(imageList) { image ->
            Card(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable { /* Handle click */ },
                shape = RoundedCornerShape(35.dp),
                elevation = CardDefaults.cardElevation(3.dp)
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "CourseName", // decorative
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(200.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun CarouselPreview() {
    val imageList = listOf(
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_background
    ) // Replace with your actual image resource IDs
    ImageCarousel(imageList = imageList)
}