package com.example.cleancodetest.app

import android.app.Application
import com.example.cleancodetest.di.AppComponent
import com.example.cleancodetest.di.AppModule
import com.example.cleancodetest.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}