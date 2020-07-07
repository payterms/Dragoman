package ru.payts.dragoman.view.main

import android.app.Application
import timber.log.Timber

class App: Application() {
    companion object {
        lateinit var instance: App
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())
    }

}