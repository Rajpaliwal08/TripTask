package com.rajpaliwal.bkpraj.myapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rajpaliwal.bkpraj.myapplication.data.model.TripInfo
import com.rajpaliwal.bkpraj.myapplication.navigation.MyAppRoute
import com.rajpaliwal.bkpraj.myapplication.screens.uiComponenet.TripCard
import com.rajpaliwal.bkpraj.myapplication.viewModels.MainViewModel

@Composable
fun HomeScreen(
    mainViewModel: MainViewModel,
    navHostController: NavHostController) {

    val trips = mainViewModel.trips.collectAsState().value

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navHostController.navigate(MyAppRoute.addTripScreen) },
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Trip")
            }
        },
        content = { paddingValues ->
            TripList(mainViewModel, navHostController = navHostController, modifier = Modifier.padding(paddingValues), trips = trips)
        }
    )
}

@Composable
fun TripList(mainViewModel: MainViewModel, navHostController: NavHostController, modifier: Modifier, trips: List<TripInfo>) {
    Column(modifier = modifier.padding(top = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(
                modifier = modifier.padding(),
                text = "All Trip",
                fontSize = 20.sp
            )
//            Text(
//                modifier = modifier.clickable {
//                    mainViewModel.removeTrip()
//                },
//                text = "Clear"
//            )
        }

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(trips) { trip ->
                TripCard(trip = trip) {
                    navHostController.navigate(MyAppRoute.mapScreen)
                }
            }
        }
    }
}

