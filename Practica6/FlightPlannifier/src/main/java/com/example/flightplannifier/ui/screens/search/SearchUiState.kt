package com.example.flightplannifier.ui.screens.search

import com.example.flightplannifier.model.Airport
import com.example.flightplannifier.model.Favorite

data class SearchUiState(
    val searchQuery: String = "",
    val selectedCode: String = "",
    val airportList: List<Airport> = emptyList(),
    val favoriteList: List<Favorite> = emptyList(),
)