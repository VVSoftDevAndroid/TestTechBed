package com.vincev.bedrocktest.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vincev.bedrocktest.data.Number

@Dao
interface NumberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumberList(numbers: List<Number>)

    @Query("SELECT * FROM Number WHERE name = :name_")
    fun getNumberByName(name_: String): Number

    @Query("SELECT * FROM Number")
    suspend fun getNumberList(): List<Number>

}