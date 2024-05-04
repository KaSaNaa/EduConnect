package com.retardeddev.educonnect.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.retardeddev.educonnect.R
import com.retardeddev.educonnect.ui.theme.onPrimaryDark
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight
import com.retardeddev.educonnect.ui.theme.onSurfaceVariantDark
import com.retardeddev.educonnect.ui.theme.outlineDark
import com.retardeddev.educonnect.ui.theme.primaryDark

@Preview
@Composable
private fun ProfilePicForm() {
    Surface {
        Column(
            modifier = Modifier
                .width(412.dp)
                .height(892.dp)
                .background(onSecondaryContainerLight),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Box( modifier = Modifier
                .width(294.dp)
                .height(51.dp))

            {
                Text(
                    fontSize = 32.sp,
                    text = "Add a profile picture",
                    color = primaryDark,
                    modifier = Modifier.padding(4.dp),
                    textAlign = TextAlign.Center
                )
            }

            Box( modifier = Modifier
                .width(321.dp)
                .height(40.dp)
                )
            {
                Text(
                    text = "A picture helps people recognize you and let you know when you're signed in to your account",
                    color = onSurfaceVariantDark,
                    modifier= Modifier.padding(4.dp),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            Box( modifier = Modifier
                .width(120.dp)
                .height(120.dp)
            ){
                IconButton(
                    onClick = { /* Handle click here */ },
                    modifier = Modifier
                        .fillMaxSize()
                        .background(primaryDark, CircleShape)
                ) {
                    val icon: Painter = painterResource(id = R.drawable.ic_launcher_background)
                    Icon(
                        painter = icon,
                        contentDescription = "Custom Icon",
                        tint = onPrimaryDark,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
                                   .padding(30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { /* Handle click here */ },
                    modifier = Modifier
                        .width(105.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(primaryDark)
                ) {
                    Text("Continue", color = onPrimaryDark)
                }

                OutlinedButton(
                    onClick = { /* Handle click here */ },
                    modifier = Modifier
                        .width(105.dp)
                        .height(40.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = outlineDark
                    )
                ) {
                    Text("Skip", color = primaryDark)
                }
            }
        }
    }
}