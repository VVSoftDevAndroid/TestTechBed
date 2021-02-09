package com.vincev.bedrocktest.di

import com.vincev.bedrocktest.api.NumberApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("http://dev.tapptic.com")
            .client(OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NumberApi::class.java)
    }
}