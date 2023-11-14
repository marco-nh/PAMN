package com.example.flightplannifier.data

import com.example.flightplannifier.model.Airport
import com.example.flightplannifier.model.Favorite
import kotlinx.coroutines.flow.Flow

interface FlightRepo {

    fun getAllAirportsFlow(): Flow<List<Airport>>
    fun getAllAirportsFlow(query: String): Flow<List<Airport>>
    fun getAirportByCodeFlow(code: String): Flow<Airport>

    suspend fun getAllAirports(): List<Airport>
    suspend fun getAllAirports(query: String): List<Airport>
    suspend fun getAirportByCode(code: String): Airport

    suspend fun getAirportById(id: Int): Airport

    fun getAllFavoritesFlightsFlow(): Flow<List<Favorite>>
    suspend fun getAllFavoritesFlights(): List<Favorite>
    suspend fun insertFavoriteFlight(flight: Favorite)
    suspend fun deleteFavoriteFlight(flight: Favorite)

    suspend fun getSingleFavorite(departureCode: String, destinationCode: String): Favorite
}