package com.vincev.bedrocktest

import com.vincev.bedrocktest.data.Number
import com.vincev.bedrocktest.data.NumberDetail

object MockTestUtil {
    fun mockNumberDetail() = NumberDetail(
         "2",
        "Ni",
        "url"
    )

    fun mockNumberList() = listOf(Number(name = "1", image = "url"), Number(name = "2", image = "url2"))
}