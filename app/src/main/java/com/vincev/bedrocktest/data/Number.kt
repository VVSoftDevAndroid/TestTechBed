package com.vincev.bedrocktest.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Number(
    @PrimaryKey @SerializedName("name") val name : String,
    @SerializedName("image") val image : String
)
