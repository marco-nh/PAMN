package com.example.flightplannifier.data

import android.content.Context

interface AppContainer {
    val flightRepository: FlightRepo
}


class AppDataContainer(private val context: Context) : AppContainer {

    override val flightRepository: FlightRepo by lazy {
        OfflineFlightRepository(FlightDB.getDatabase(context).flightDao())
    }
}