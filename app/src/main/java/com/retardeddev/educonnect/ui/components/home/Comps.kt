package com.retardeddev.educonnect.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
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
import androidx.navigation.NavController
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.data.model.Course
import com.retardeddev.educonnect.navigation.NavigationItem
import com.retardeddev.educonnect.ui.theme.onBackgroundDark
import com.retardeddev.educonnect.ui.theme.onSecondaryDark
import com.retardeddev.educonnect.ui.theme.primaryContainerDark
import com.retardeddev.educonnect.ui.theme.secondaryDark


@Suppress("SameParameterValue")
@Composable
fun WelcomeCard(name: String) {
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
                    withStyle(
                        style = SpanStyle(
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(name)
                    }
                },
                color = onBackgroundDark,
                fontSize = MaterialTheme.typography.labelSmall.fontSize,
                lineHeight = 16.7.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp, 13.dp)
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
fun CoursesCarousel(navController: NavController, courses: List<Course>) {
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
            .height(214.dp)
    ) {
        Column { // Use Column to stack the elements vertically
            Row(modifier = Modifier.padding(20.dp, 5.dp))
            {
                Text(
                    text = "Courses",
                    style = MaterialTheme.typography.titleMedium,
                    color = onBackgroundDark,
                    onTextLayout = {/*TODO*/ },
                    modifier = Modifier
                        .weight(1f) // This will take up the remaining space
                        .padding(1.dp, 14.dp)
                        .align(Alignment.CenterVertically) // Align to center vertically
                )
                FilledTonalButton(
                    onClick = { navController.navigate(NavigationItem.CourseList.route) },
                    colors = ButtonDefaults.outlinedButtonColors(onSecondaryDark),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .height(33.dp)
                        .width(70.dp)
                        .align(Alignment.CenterVertically) // Align to center vertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp) // Adjust this value to your preference
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ArrowForward, // Replace with your own icon
                            contentDescription = "Icon description", // Accessibility description
                            tint = onBackgroundDark,
                            modifier = Modifier.padding(2.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            "View",
                            color = onBackgroundDark,
                            onTextLayout = {/*TODO*/ },
                            fontSize = MaterialTheme.typography.labelMedium.fontSize,
                        )
                    }
                }
            }
            Box(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)) {
                val imageList = listOf(
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background
                )
                ImageCarousel(imageList = imageList)
            }
        }
    }
}

@Composable
fun RecentUpdates(updates: List<String>) {
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
            .height(246.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp, 5.dp)) {
            Row {
                Text(
                    text = "Recent Updates",
                    style = MaterialTheme.typography.titleMedium,
                    color = onBackgroundDark,
                    onTextLayout = {/*TODO*/ },
                    modifier = Modifier
                        .weight(1f) // This will take up the remaining space
                        .padding(1.dp, 14.dp)
                        .align(Alignment.CenterVertically) // Align to center vertically
                )
            }
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
                            HorizontalDivider()
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewWelcomeCard() {
    @Suppress("SameParameterValue")
    WelcomeCard(name = "Pasindu Ranawakage")
}

@Preview
@Composable
private fun UpdatesPreview() {
    val dummyUpdates = listOf("Update 1", "Update 2", "Update 3")
    RecentUpdates(dummyUpdates)
}

