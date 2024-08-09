package com.rajpaliwal.bkpraj.myapplication.screens.uiComponenet

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TripTextField(
    label: String,
    placeholder: String,
    onTextChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = text,
            onValueChange = {
                text = it
                onTextChange(it)
            },
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTripTextField() {
    MaterialTheme {
        TripTextField(
            label = "Name",
            placeholder = "Enter your name",
            onTextChange = {}
        )
    }
}
