package com.hamza.metroguide.data.local.entity

import androidx.room.Entity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "station_on_line")
@Serializable
data class StationOnLine(
    @SerialName("station_id")val stationId: String,
    @SerialName("line_id") val lineId: String,
    val sequence: Int
)

@Serializable
data class StationOnLineFile(
   @SerialName("station_on_line") val stationOnLine: List<StationOnLine>)