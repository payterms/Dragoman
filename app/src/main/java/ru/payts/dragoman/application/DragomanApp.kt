package ru.payts.dragoman.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import ru.payts.dragoman.di.application
import ru.payts.dragoman.di.mainScreen
import org.koin.core.context.startKoin
import ru.payts.dragoman.di.historyScreen

class DragomanApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}

