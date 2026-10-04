package com.hamza.metroguide.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "lines")
@Serializable

data class Line(
    @PrimaryKey val id: String,
    val name: String,
    val color: String
)

@Serializable
data class LinesFile(val lines: List<Line>)