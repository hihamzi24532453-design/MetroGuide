package com.hamza.metroguide.data.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hamza.metroguide.data.local.entity.Line
import com.hamza.metroguide.data.local.entity.Station
import com.hamza.metroguide.data.local.entity.StationOnLine

@Dao

interface LineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(lines: List<Line>)

    @Query("SELECT * FROM lines")
    suspend fun getAll(): List<Line>

    @Query("SELECT COUNT(*) FROM lines")
    suspend fun count(): Int
}

interface StationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(stations: List<Station>)

    @Query("SELECT * FROM stations")
    suspend fun getAll(): List<Station>

    @Query("SELECT COUNT(*) FROM stations")
    suspend fun count(): Int
}

interface StationOnLineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(stationOnLine: List<StationOnLine>)

    @Query("SELECT * FROM station_on_line WHERE lineId = :lineId ORDER BY sequence")
    suspend fun getForLine(lineId: String): List<StationOnLine>

    @Query("SELECT lineId FROM station_on_line WHERE stationId = :stationId")
    suspend fun getLinesFor(stationId: String): List<String>
}