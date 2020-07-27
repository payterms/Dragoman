package payts.ru.Dragoman.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DragomanApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@DragomanApp) }
    }
}
