import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.retardeddev.educonnect.ui.theme.onPrimaryContainerDark
import com.retardeddev.educonnect.ui.theme.onSurfaceDark
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MyBottomSheet() {
    val scope = rememberCoroutineScope()
    val sheetState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(scaffoldState = sheetState,
        sheetContainerColor = Color(0xFF4A4458),
        contentColor = onSurfaceDark,
        sheetContent = {
            Surface(color = Color(0xFF4A4458)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)

                    ) {

                        // Text Field
                        val text = remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = text.value,
                            onValueChange = { text.value = it },
                            label = { Text("Enter new name", color = Color.White) },
                            placeholder = { Text("Enter your new name", color = Color.White) },
                            modifier = Modifier.fillMaxWidth(),

                            )
                        Text(
                            text = "You can change your name every 3 months.",
                            onTextLayout = {/*to do*/ },
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                            color = onPrimaryContainerDark,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(10.dp),


                            )
                        Spacer(modifier = Modifier.height(100.dp))
                        // Buttons
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,

                            ) {
                            Button(onClick = { /*TODO*/ }) {
                                Text("Cancel", color = Color.White)
                            }
                            Button(onClick = { /*TODO*/ }) {
                                Text("Save")
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
                scope.launch {
                    val bottomSheetState = sheetState.bottomSheetState
                    if (bottomSheetState.currentValue == bottomSheetState.currentValue) bottomSheetState.expand()
                    else bottomSheetState.hide()
                }
            }, content = { })
        })
}
