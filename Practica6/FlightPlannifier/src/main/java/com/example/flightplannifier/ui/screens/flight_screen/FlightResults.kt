package com.example.flightplannifier.ui.screens.flight_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightplannifier.model.Airport
import com.example.flightplannifier.model.Favorite
import com.example.flightplannifier.ui.screens.search.SearchTextField
import com.example.flightplannifier.ui.screens.search.SearchViewModel

@Composable
fun FlightResults(
    modifier: Modifier = Modifier,
    departureAirport: Airport,
    destinationList: List<Airport>,
    favoriteList: List<Favorite>,
    onFavoriteClick: (String, String) -> Unit
) {
    val viewModel: SearchViewModel = viewModel(factory = SearchViewModel.Factory)
    val uiState = viewModel.uiState.collectAsState().value
    Text(
        text = "Introudzca aerolineas:",
        fontWeight = FontWeight.Bold
    )
    SearchTextField(
        uiState.searchQuery,
        onQueryChange = {
            viewModel.updateQuery(it)
            viewModel.updateSelectedCode("")
            viewModel.onQueryChange(it)
        }
    )
    Column {

        LazyColumn(
            modifier = modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            items(destinationList, key = { it.id }) { item ->
                val isFavorite = favoriteList.find { f ->
                    f.departureCode == departureAirport.code &&
                            f.destinationCode == item.code }

                FlightRow(
                    isFavorite = isFavorite != null,
                    departureAirportCode = departureAirport.code,
                    departureAirportName = departureAirport.name,
                    destinationAirportCode = item.code,
                    destinationAirportName = item.name,
                    onFavoriteClick = onFavoriteClick
                )
            }
        }
    }
}
