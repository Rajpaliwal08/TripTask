package com.rajpaliwal.bkpraj.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rajpaliwal.bkpraj.myapplication.screens.AddTrip
import com.rajpaliwal.bkpraj.myapplication.screens.HomeScreen
import com.rajpaliwal.bkpraj.myapplication.screens.MapScreen
import com.rajpaliwal.bkpraj.myapplication.viewModels.MainViewModel

@Composable
fun MyAppNavigation() {
    val navController = rememberNavController()
    val mainViewModel: MainViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = MyAppRoute.homeScreen) {
        composable(route = MyAppRoute.homeScreen) {
            HomeScreen(mainViewModel, navController)
        }
        composable(route = MyAppRoute.addTripScreen) {
            AddTrip(mainViewModel)
        }
        composable(route = MyAppRoute.mapScreen) {
            MapScreen()
        }
    }
}