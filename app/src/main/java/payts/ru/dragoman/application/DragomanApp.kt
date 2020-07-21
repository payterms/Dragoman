package payts.ru.dragoman.application

import android.app.Application
import payts.ru.dragoman.di.application
import payts.ru.dragoman.di.historyScreen
import payts.ru.dragoman.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DragomanApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}
