package com.vincev.bedrocktest.data

import com.google.gson.annotations.SerializedName

data class NumberDetail(
    @SerializedName("name") val name : String,
    @SerializedName("text") val text : String,
    @SerializedName("image") val image : String
)
