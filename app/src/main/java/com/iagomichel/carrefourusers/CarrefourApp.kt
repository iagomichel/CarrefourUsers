package com.iagomichel.carrefourusers

import android.app.Application
import com.iagomichel.carrefourusers.di.carrefourModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CarrefourApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CarrefourApp)
            modules(carrefourModules)
        }
    }
}
