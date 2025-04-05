package com.codeitsolo.scribbledash

import android.app.Application
import com.codeitsolo.scribbledash.di.initKoin
import org.koin.android.ext.koin.androidContext

class ScribbleDashApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@ScribbleDashApplication)
        }
    }
}