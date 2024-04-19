package com.retardeddev.educonnect.ui.components.courses

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyText(description: String) {
    Text( " $description ",
        color = Color.White,
        onTextLayout = {/*TODO*/},
        fontSize = 16.sp)
}
@Preview
@Composable
fun Print() {
    MyText("Very nice")
}

@Composable
fun Text1(a: String) {
        Row {
            Text( " Commencement : ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp )
            Spacer(modifier = Modifier.width(47.dp))
            Text( " $a ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp )
        }
    }

@Preview
@Composable
fun Print1() {
    Text1("This is good")
}


@Composable
fun Text2(b: String) {
    Row { // Use a Row to arrange the text and icon horizontally
        Text( " Duration : ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp )
        Spacer(modifier = Modifier.width(109.dp))
        Text( " $b ", onTextLayout = {/*TODO*/} , color = Color.White,fontSize = 16.sp)
    }
}

@Preview
@Composable
fun Print2() {
    Text2("6 months")
}

@Composable
fun Text3(c: String) {
    Row { // Use a Row to arrange the text and icon horizontally
        Text( " Fee : ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp )
        Spacer(modifier = Modifier.width(147.dp))
        Text( " $c ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp )
    }
}

@Preview
@Composable
fun Print3() {
    Text3("2500 LKR")
}

@Composable
fun Text4(d: Int) {
    Row { // Use a Row to arrange the text and icon horizontally
        Text( " Maximum Participation : ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp)
        Spacer(modifier = Modifier.width(8.dp))
        Text( " $d ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp)
    }
}

@Preview
@Composable
fun Print4() {
    Text4(75)
}

@Composable
fun Text5(e: String) {
    Row { // Use a Row to arrange the text and icon horizontally
        Text( " Branches : ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp )
        Spacer(modifier = Modifier.width(109.dp))
        Text( " $e ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp )
    }
}

@Preview
@Composable
fun Print5() {
    Text5("Colombo")
}

@Composable
fun Text6(f: String) {
    Row { // Use a Row to arrange the text and icon horizontally
        Text( " Registration closing date : ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp )
        Spacer(modifier = Modifier.width(0.dp))
        Text( " $f ", onTextLayout = {/*TODO*/}, color = Color.White,fontSize = 16.sp )
    }
}

@Preview
@Composable
fun Print6() {
    Text6("April 1st 2001")
}


@Composable
fun OutlinedButtonWithIcon1(onClick: () -> Unit) {
    OutlinedButton(onClick = onClick) {
        Row { // Use a Row to arrange the text and icon horizontally

            IconButton(onClick = { /* Handle info icon click if needed */ }) {
                Icon(Icons.Filled.DateRange, contentDescription = "More Info", tint = Color.White,modifier = Modifier.size(20.dp)) // Assuming you want an Info icon
            }
            Text("Find nearest branch",
                fontSize = 14.sp ,
                modifier = Modifier.padding(top = 14.dp, bottom = 8.dp),
                onTextLayout = {/*TODO*/})

        }
    }
}

@Preview
@Composable
private fun PreviewButton() {
    OutlinedButtonWithIcon1(onClick ={/*TODO*/})
}

@Composable
fun FilledButton1(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Row { // Use a Row to arrange the text and icon horizontally

            IconButton(onClick = { /* Handle info icon click if needed */ }) {
                Icon(Icons.Filled.Check, contentDescription = "More Info", tint = Color.White,modifier = Modifier.size(20.dp)) // Assuming you want an Info icon
            }
            Text("Register Now",
                fontSize = 14.sp ,
                modifier = Modifier.padding(top = 14.dp, bottom = 8.dp),
                onTextLayout = {/*TODO*/})

        }
    }
}
@Preview
@Composable
private fun PreviewButton1() {
    FilledButton1(onClick ={/*TODO*/})
}
