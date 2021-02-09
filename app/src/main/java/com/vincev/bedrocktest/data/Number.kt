package com.vincev.bedrocktest.data

import com.google.gson.annotations.SerializedName

data class Number(
    @SerializedName("name") val name : String,
    @SerializedName("image") val image : String
)
