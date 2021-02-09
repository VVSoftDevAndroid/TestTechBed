package com.vincev.bedrocktest.di

import com.vincev.bedrocktest.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
}