package com.retardeddev.educonnect.ui.components.profile

import android.widget.ScrollView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.errorContainerDark
import com.retardeddev.educonnect.ui.theme.onBackgroundDark
import com.retardeddev.educonnect.ui.theme.onPrimaryContainerDark
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight
import com.retardeddev.educonnect.ui.theme.onSecondaryDark
import com.retardeddev.educonnect.ui.theme.secondaryDark


//@Preview
@Composable
fun ProfilePicture() {
    Column(
        modifier = Modifier
            .background(onSecondaryContainerLight)
            .padding(20.dp),



        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "image description",
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .size(74.dp)
                .clip(RoundedCornerShape(50.dp))
        )
        Text(
            text = "Deenath Damsinghe",
            onTextLayout = {/*to do*/ },
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Bold,
            color = onPrimaryContainerDark,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(30.dp)

        )

    }

}

//@Preview
@Composable
private fun PersonalInfo() {

    Box(
        modifier = Modifier
            .background(onSecondaryContainerLight)
            .padding(10.dp)

    ) {
        Text(
            text = "Personal information",
            onTextLayout = {/*to do*/ },
            fontSize = MaterialTheme.typography.labelLarge.fontSize,
            fontWeight = FontWeight.Bold,
            color = onPrimaryContainerDark,

            )
        Box(
            Modifier.padding(10.dp, 40.dp, 10.dp, 10.dp)
        ) {
            val infoItemsList = listOf(
                "Name",
                "Birthday",
                "Mobile Number",
                "Gender",
                "NIC",
                "Address",
                "Living City"
            )
            InfoItems(infoitems = infoItemsList)
        }
    }


}

@Composable
private fun InfoItems(infoitems: List<String>) {

    Column {
        Card(modifier = Modifier.padding(10.dp)) {
            infoitems.forEach { infoItem ->
                ListItem(
                    headlineContent = {
                        Text(
                            infoItem,
                            onTextLayout = {/*TODO*/ },
                            color = secondaryDark


                        )

                    },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Update",
                            tint = onBackgroundDark
                        )
                    },
                    colors = ListItemDefaults.colors(onSecondaryDark),
                )
                Divider(
                    modifier = Modifier
                        .width(350.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
private fun PreviewInfoItem() {
    val infoItemsList =
        listOf("Name", "Birthday", "Mobile Number", "Gender", "NIC", "Address", "Living City")
    InfoItems(infoitems = infoItemsList)
}


//@Preview
@Composable
private fun AccocuntManagement() {
    Column {
        Box(
            modifier = Modifier
                .background(onSecondaryContainerLight)
                .padding(10.dp)

        ) {
            Text(
                text = "Account Management",
                onTextLayout = {/*to do*/ },
                fontSize = MaterialTheme.typography.labelLarge.fontSize,
                fontWeight = FontWeight.Bold,
                color = onPrimaryContainerDark,
            )
            Box(
                Modifier.padding(10.dp, 40.dp, 10.dp, 10.dp)
            ) {
                AccountDelete()
            }
        }

    }

}


@Composable
private fun AccountDelete(deleteItems: List<String> = listOf("Delete Account", "Log Out")) {

    Column {
        Card(modifier = Modifier.padding(10.dp)) {
            deleteItems.forEach { deleteItems ->
                ListItem(
                    headlineContent = {
                        Text(
                            deleteItems,
                            onTextLayout = {/*TODO*/ },
                            color = errorContainerDark


                        )

                    },
                    trailingContent = {
                        Icon(
                            Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Update",
                            tint = errorContainerDark
                        )
                    },
                    colors = ListItemDefaults.colors(onSecondaryDark),
                )
                Divider(
                    modifier = Modifier
                        .width(350.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }

}
@Preview
@Composable
fun CombinedScreen() {


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(onSecondaryContainerLight)
        ) {
            item{
                ProfilePicture()
                Spacer(modifier = Modifier.height(16.dp))
                PersonalInfo()
                Spacer(modifier = Modifier.height(16.dp))
                AccocuntManagement()
            }
        }
    }

