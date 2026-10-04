package com.hamza.metroguide.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "stations")
@Serializable
data class Station(
    @PrimaryKey val id: String,
    val name: String,
    val lat: Double,
    val lng: Double
)

@Serializable
data class StationsFile(val stations: List<Stations>)