package com.retardeddev.educonnect.ui.pages.courses

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
import com.retardeddev.educonnect.ui.components.courses.ButtonColumn
import com.retardeddev.educonnect.ui.components.courses.MyText
import com.retardeddev.educonnect.ui.components.courses.Text1
import com.retardeddev.educonnect.ui.components.courses.Text2
import com.retardeddev.educonnect.ui.components.courses.Text3
import com.retardeddev.educonnect.ui.components.courses.Text4
import com.retardeddev.educonnect.ui.components.courses.Text5
import com.retardeddev.educonnect.ui.components.courses.Text6
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight

@Preview
@Composable
fun FinalDetailPage() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 0.dp),
        modifier = Modifier
            .width(412.dp)
            .height(768.dp)
            .background(onSecondaryContainerLight)
    ) {
        item {
            MyText("Very nice")
        }
        item {
            Text1("This is good")
        }
        item {
            Text2("6 months")
        }
        item {
            Text3("2500 LKR")
        }
        item {
            Text4(75)
        }
        item {
            Text5("Colombo")
        }
        item {
            Text6("April 1st 2001")
        }
        item {
            ButtonColumn()
        }
    }
}