package com.rajpaliwal.bkpraj.myapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajpaliwal.bkpraj.myapplication.screens.uiComponenet.TripTextField
import com.rajpaliwal.bkpraj.myapplication.viewModels.MainViewModel

@Composable
fun AddTrip(
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }
    var pickupAddress by remember { mutableStateOf("") }
    var dropOffAddress by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var pickupTime by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Add Trip",
            fontSize = 22.sp,
            modifier = modifier.padding(bottom = 12.dp)
        )
        TripTextField(label = "Name", placeholder = "Name") { name = it }
        TripTextField(label = "Pickup Address", placeholder = "Pickup Address") {pickupAddress = it}
        TripTextField(label = "DropOff Address", placeholder = "DropOff Address") {dropOffAddress = it}
        TripTextField(label = "Price", placeholder = "Price") {price = it}
        TripTextField(label = "Pickup Time", placeholder = "Pickup Time") {pickupTime = it}

        Button(onClick = {
            mainViewModel.addTrip(
                customerName = name,
                pickupAddress = pickupAddress,
                dropOffAddress = dropOffAddress,
                price = price,
                pickupTime = pickupTime
            )
        }) {
            Text(text = "Save Trip")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAddTrip() {
    MaterialTheme {
//        AddTrip()
    }
}
