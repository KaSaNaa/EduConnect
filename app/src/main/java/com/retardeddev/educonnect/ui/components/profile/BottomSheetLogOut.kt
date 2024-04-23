package com.retardeddev.educonnect.ui.components.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.theme.onPrimaryContainerDark
import com.retardeddev.educonnect.ui.theme.onSurfaceDark
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MyBottomSheetLogOut() {
    val scope2 = rememberCoroutineScope()
    val sheetState2 = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(scaffoldState = sheetState2,
        sheetContainerColor = Color(0xFF4A4458),
        contentColor = onSurfaceDark,
        sheetContent = {
            Surface(color = Color(0xFF4A4458)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Text(
                            text = "Are you sure you want to log out?",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            color = onPrimaryContainerDark,
                            modifier = Modifier.padding(bottom = 50.dp)
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(18.dp),
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = { /* Perform logout action */ },
                                modifier = Modifier.fillMaxWidth(0.5f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFFFD9E1)
                                )
                            ) {
                                Text("Log Out", color = Color.Black, fontWeight = FontWeight.Bold)
                            }

                            OutlinedButton(
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                                border = BorderStroke(0.dp, Color(0xFFD3BCFD)),
                                onClick = {
                                    scope2.launch {
                                        val bottomSheetState = sheetState2.bottomSheetState
                                        bottomSheetState.hide()
                                    }
                                },
                                modifier = Modifier.fillMaxWidth(0.2f),
                            ) {
                                Text("No", fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
        },
        sheetPeekHeight = 0.dp,
        sheetShape = RoundedCornerShape(20.dp),
        content = {
            Button(onClick = {
                scope2.launch {
                    val bottomSheetState = sheetState2.bottomSheetState
                    if (bottomSheetState.currentValue == bottomSheetState.currentValue) bottomSheetState.expand()
                    else bottomSheetState.hide()
                }
            }, content = { })
        })
}