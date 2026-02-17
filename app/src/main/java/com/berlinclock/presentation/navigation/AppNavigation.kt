package com.berlinclock.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.berlinclock.presentation.screen.BerlinClockScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val berlinClockScreenName = ScreenName.BERLIN_CLOCK_SCREEN.name
    NavHost(navController, startDestination = berlinClockScreenName) {
        composable(route = berlinClockScreenName) {
            BerlinClockScreen()
        }
    }
}