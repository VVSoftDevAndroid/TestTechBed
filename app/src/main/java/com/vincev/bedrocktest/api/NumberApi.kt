package com.vincev.bedrocktest.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import com.vincev.bedrocktest.data.Number
import com.vincev.bedrocktest.data.NumberDetail
import retrofit2.http.Query

interface NumberApi {
    @GET("/test/json.php")
    suspend fun getNumberList(): Response<List<Number>>

    @GET("/test/json.php")
    suspend fun getNumberDetail(@Query("name") numberName: String): Response<NumberDetail>
}