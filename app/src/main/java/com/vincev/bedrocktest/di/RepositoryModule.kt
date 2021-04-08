package com.vincev.bedrocktest.di

import com.vincev.bedrocktest.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { MainRepository(get(), get()) }

}