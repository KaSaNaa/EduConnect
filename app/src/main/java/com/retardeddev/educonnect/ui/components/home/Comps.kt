package com.retardeddev.educonnect.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.onBackgroundDark
import com.retardeddev.educonnect.ui.theme.primaryContainerDark


@Composable
private fun WelcomeCard(name: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = primaryContainerDark
        ),
        modifier = Modifier
            .shadow(
                elevation = 2.dp,
                spotColor = Color(0x4D000000),
                ambientColor = Color(0x4D000000)
            )
            .shadow(
                elevation = 3.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .width(360.dp)
            .height(146.dp)
    ) {
        Box(modifier = Modifier.padding(30.dp, 36.dp, 0.dp, 0.dp)) {
            Text(
                text = buildAnnotatedString {
                    append("Welcome Back,\n\n")
                    withStyle(style = SpanStyle(
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontWeight = FontWeight.Bold
                    )) {
                        append(name)
                    }
                },
                color = onBackgroundDark,
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                lineHeight = 16.7.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.align(Alignment.TopStart).padding(10.dp, 13.dp)
            )

            Box(modifier = Modifier.padding(220.dp, 0.dp, .0.dp, 0.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds,
                    alignment = Alignment.CenterEnd,
                    modifier = Modifier
                        .size(74.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .padding()
                )
            }
        }
    }
}


@Composable
fun CoursesCarousel() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = primaryContainerDark
        ),
        modifier = Modifier
            .shadow(
                elevation = 2.dp,
                spotColor = Color(0x4D000000),
                ambientColor = Color(0x4D000000)
            )
            .shadow(
                elevation = 3.dp,
                spotColor = Color(0x26000000),
                ambientColor = Color(0x26000000)
            )
            .width(360.dp)
            .height(146.dp)
    ) {
        Text(
            text = "Courses",
            style = MaterialTheme.typography.titleMedium,
            color = onBackgroundDark,
            modifier = Modifier
                .padding(15.dp, 10.dp),

        )
    }
}

@Preview
@Composable
private fun PreviewWelcomeCard() {
    WelcomeCard(name = "Pasindu Ranawakage")
}

@Preview
@Composable
private fun CoursesPrev() {
    CoursesCarousel()
}