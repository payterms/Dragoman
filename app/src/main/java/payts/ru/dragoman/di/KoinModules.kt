package payts.ru.dragoman.di

import androidx.room.Room
import payts.ru.history.view.history.HistoryInteractor
import payts.ru.history.view.history.HistoryViewModel
import payts.ru.model.data.SearchResult
import payts.ru.model.room.HistoryDataBase
import payts.ru.repository.*
import payts.ru.dragoman.view.main.MainInteractor
import payts.ru.dragoman.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResult>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResult>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
