package com.vincev.bedrocktest

import com.nhaarman.mockitokotlin2.*
import com.vincev.bedrocktest.MockTestUtil.mockNumberDetail
import com.vincev.bedrocktest.MockTestUtil.mockNumberList
import com.vincev.bedrocktest.api.NumberApi
import com.vincev.bedrocktest.repository.MainRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var mainRepository: MainRepository
    private val numberApi: NumberApi = mock()

    @Test
    fun fetchNumberDetailTest() = runBlocking {
        whenever(numberApi.getNumberDetail("2")).thenReturn(Response.success(mockNumberDetail()))
        mainRepository = MainRepository(numberApi)
        val detail = mainRepository.loadNumberDetail("2", onSuccess = {}, onError = {}).first()

        Assert.assertEquals(detail, mockNumberDetail())
    }

    @Test
    fun fetchNumberListTest() = runBlocking {
        whenever(numberApi.getNumberList()).thenReturn(Response.success(mockNumberList()))
        mainRepository = MainRepository(numberApi)
        val numberList = mainRepository.loadNumberList(onSuccess = {}, onError = {}).first()

        Assert.assertEquals(numberList, mockNumberList())
    }
}