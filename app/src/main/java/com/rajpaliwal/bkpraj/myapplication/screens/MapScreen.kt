package com.rajpaliwal.bkpraj.myapplication.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    startLatLng: LatLng = LatLng(40.9971, 29.1007),
    endLatLng: LatLng = LatLng(40.9971, 29.1007)
) {
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(startLatLng, 5f)
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = startLatLng),
            title = "Start Location"
        )
        Marker(
            state = MarkerState(position = endLatLng),
            title = "End Location"
        )
        Polyline(
            points = listOf(startLatLng, endLatLng),
            clickable = true,
            color = Color.Blue,
            width = 5f
        )
    }
}