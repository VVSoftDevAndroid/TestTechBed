package com.vincev.bedrocktest.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vincev.bedrocktest.data.Number

@Database(entities = [Number::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun numberDao(): NumberDao
}
