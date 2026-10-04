package com.hamza.metroguide.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hamza.metroguide.data.local.Dao.LineDao
import com.hamza.metroguide.data.local.Dao.StationDao
import com.hamza.metroguide.data.local.Dao.StationOnLineDao
import com.hamza.metroguide.data.local.entity.Line
import com.hamza.metroguide.data.local.entity.StationOnLine
import com.hamza.metroguide.data.local.entity.Station

@Database (
    entities = [Line::class, Station::class, StationOnLine::class],
    version = 1,
    exportSchema = false
)

abstract class MetroDatabase: RoomDatabase() {
    abstract fun lineDao(): LineDao
    abstract fun stationDao(): StationDao
    abstract fun stationOnLineDao(): StationOnLineDao
}


