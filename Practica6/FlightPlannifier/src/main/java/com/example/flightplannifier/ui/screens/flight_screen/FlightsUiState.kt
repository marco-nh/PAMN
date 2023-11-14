package com.example.flightplannifier.ui.screens.flight_screen

import com.example.flightplannifier.model.Airport
import com.example.flightplannifier.model.Favorite

data class FlightsUiState(
    val code: String = "",
    val favoriteList: List<Favorite> = emptyList(),
    val destinationList: List<Airport> = emptyList(),
    val departureAirport: Airport = Airport(),
)
