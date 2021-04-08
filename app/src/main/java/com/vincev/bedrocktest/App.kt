package com.vincev.bedrocktest

import android.app.Application
import com.vincev.bedrocktest.di.networkModule
import com.vincev.bedrocktest.di.persistenceModule
import com.vincev.bedrocktest.di.repositoryModule
import com.vincev.bedrocktest.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}