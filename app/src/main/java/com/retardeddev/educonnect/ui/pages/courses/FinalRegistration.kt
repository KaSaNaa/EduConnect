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
import com.retardeddev.educonnect.ui.components.courses.Address
import com.retardeddev.educonnect.ui.components.courses.BranchPrint
import com.retardeddev.educonnect.ui.components.courses.City
import com.retardeddev.educonnect.ui.components.courses.CoursePrint
import com.retardeddev.educonnect.ui.components.courses.DatePickerPrev
import com.retardeddev.educonnect.ui.components.courses.Email
import com.retardeddev.educonnect.ui.components.courses.FilledButton
import com.retardeddev.educonnect.ui.components.courses.GenderPrint
import com.retardeddev.educonnect.ui.components.courses.MobilePrint
import com.retardeddev.educonnect.ui.components.courses.NIC
import com.retardeddev.educonnect.ui.components.courses.Name
import com.retardeddev.educonnect.ui.components.courses.OutlinedButtonWithIcon
import com.retardeddev.educonnect.ui.theme.onSecondaryContainerLight

@Preview
@Composable
fun FinalRegistration() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        contentPadding = PaddingValues(0.dp, 0.dp, 0.dp, 0.dp),
        modifier = Modifier
            .width(412.dp)
            .height(768.dp)
            .background(onSecondaryContainerLight)
    ) {
        item {
            Name()
        }
        item {
            Address()
        }
        item {
            City()
        }
        item {
            NIC()
        }
        item {
            Email()
        }
        item {
            MobilePrint()
        }
        item {
            GenderPrint()
        }
        item {
            DatePickerPrev()
        }
        item {
            CoursePrint()
        }
        item {
            BranchPrint()
        }
        item {
            OutlinedButtonWithIcon()
        }
        item {
            RegistrationButton()
        }
    }
}

@Preview
@Composable
fun RegistrationButton() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.Top),
        horizontalAlignment = Alignment.Start,
        contentPadding = PaddingValues(0.dp, 20.dp, 0.dp, 0.dp),
        modifier = Modifier
            .width(412.dp)
            .height(768.dp)
            .background(onSecondaryContainerLight)
    ) {
        item {
            FilledButton()
        }

    }
}
