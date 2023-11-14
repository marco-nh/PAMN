package com.example.flightplannifier.data


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flightplannifier.model.Airport
import com.example.flightplannifier.model.Favorite

@Database(entities = [Airport::class, Favorite::class], version = 1, exportSchema = false)
abstract class FlightDB: RoomDatabase() {

    abstract fun flightDao(): FlightDao

    companion object {
        @Volatile
        private var Instance: FlightDB? = null

        fun getDatabase(context: Context): FlightDB {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    FlightDB::class.java,
                    "flight_database"
                )
                    .createFromAsset("database/flight_search.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}