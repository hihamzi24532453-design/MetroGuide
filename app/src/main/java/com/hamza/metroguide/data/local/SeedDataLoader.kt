package com.hamza.metroguide.data.local

import android.content.Context
import androidx.room.withTransaction
import com.hamza.metroguide.data.local.entity.LinesFile
import com.hamza.metroguide.data.local.entity.StationOnLineFile
import com.hamza.metroguide.data.local.entity.StationsFile
import kotlinx.serialization.json.Json

class SeedDataLoader(
    val context: Context,
    val database: MetroDatabase
) {
    private val json = Json { ignoreUnknownKeys = true }

    suspend fun seedIfNeeded(){
        if (database.stationDao().count() > 0) return

        val linesText = readAsset("lines.json")
        val stationsText = readAsset("stations.json")
        val stationOnLineText = readAsset("station_on_line.json")

        val lines = json.decodeFromString<LinesFile>(linesText).lines
        val stations = json.decodeFromString<StationsFile>(stationsText).stations
        val stationOnLine = json.decodeFromString<StationOnLineFile>(stationOnLineText).stationOnLine

        database.withTransaction {
            database.lineDao().insertAll(lines)
            database.stationDao().insertAll(stations)
            database.stationOnLineDao().insertAll(stationOnLine)
        }
    }

    private fun readAsset(fileName: String): String =
        context.assets.open(fileName).bufferedReader().use { it.readText() }

}

