package com.example.flightplannifier

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.flightplannifier.ui.screens.flight_screen.FlightScreen
import com.example.flightplannifier.ui.screens.flight_screen.FlightScreenDestination
import com.example.flightplannifier.ui.screens.search.SearchDestination
import com.example.flightplannifier.ui.screens.search.SearchScreen

@Composable
fun FlightPlannifer() {
    val navController = rememberNavController()
    Scaffold() { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = SearchDestination.route,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(route = SearchDestination.route) {
                Text(
                    text = "Introudzca aerolineas:",
                    fontWeight = FontWeight.Bold
                )
                SearchScreen(
                    modifier = Modifier,
                    onSelectCode = {
                        navController.navigate("${FlightScreenDestination.route}/${it}")
                    }
                )
            }
            composable(
                route = FlightScreenDestination.routeWithArgs,
                arguments = listOf(navArgument(FlightScreenDestination.codeArg) {
                    type = NavType.StringType
                }
                )
            ) { navBackStackEntry ->
                FlightScreen()

            }
        }
    }
}