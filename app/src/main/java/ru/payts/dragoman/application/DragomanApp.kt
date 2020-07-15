package ru.payts.dragoman.application

import android.app.Application
import ru.payts.dragoman.di.application
import ru.payts.dragoman.di.mainScreen
import org.koin.core.context.startKoin

class DragomanApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}

