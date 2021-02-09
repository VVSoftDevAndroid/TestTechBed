package com.vincev.bedrocktest.repository

import com.vincev.bedrocktest.api.NumberApi
import com.vincev.bedrocktest.data.Number
import com.vincev.bedrocktest.data.NumberDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class MainRepository constructor(
    private val numberApi: NumberApi
) : Repository {

    suspend fun loadNumberList(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ): Flow<List<Number>> = flow {
        numberApi.getNumberList().apply {
            val response = this
            val data = response.body()
            if (response.isSuccessful && data != null) {
                emit(data)
                onSuccess()
            } else {
                onError(response.errorBody().toString())
            }
        }
    }.flowOn(Dispatchers.IO)

    suspend fun loadNumberDetail(
        name: String,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ): Flow<NumberDetail> = flow {
        numberApi.getNumberDetail(name).apply {
            val response = this
            val data = response.body()
            if (response.isSuccessful && data != null) {
                emit(data)
                onSuccess()
            } else {
                onError(response.errorBody().toString())
            }
        }
    }.flowOn(Dispatchers.IO)

}