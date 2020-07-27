package payts.ru.Dragoman.di

import androidx.room.Room
//import payts.ru.history.view.history.HistoryInteractor
//import payts.ru.history.view.history.HistoryViewModel
import payts.ru.model.data.DataModel
import payts.ru.model.room.HistoryDataBase
import payts.ru.repository.*
import payts.ru.Dragoman.view.main.MainInteractor
import payts.ru.Dragoman.view.main.MainViewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectDependencies() = loadModules

private val loadModules by lazy {
    loadKoinModules(listOf(application, mainScreen))
}

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}
