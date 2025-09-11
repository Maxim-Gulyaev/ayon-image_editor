package com.maxim.ayon

import android.app.Application
import com.maxim.ayon.di.AppComponent
import com.maxim.ayon.di.DaggerAppComponent

class AyonApplication: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .context(this)
            .build()
    }
}