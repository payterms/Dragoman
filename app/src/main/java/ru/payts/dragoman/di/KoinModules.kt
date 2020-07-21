package ru.payts.dragoman.di

import androidx.room.Room
import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.datasource.RetrofitImplementation
import ru.payts.dragoman.model.datasource.RoomDataBaseImplementation
import ru.payts.dragoman.model.repository.Repository
import ru.payts.dragoman.model.repository.RepositoryImplementation
import ru.payts.dragoman.model.repository.RepositoryImplementationLocal
import ru.payts.dragoman.model.repository.RepositoryLocal
import ru.payts.dragoman.room.HistoryDataBase
import ru.payts.dragoman.view.history.HistoryInteractor
import ru.payts.dragoman.view.history.HistoryViewModel
import ru.payts.dragoman.view.main.MainInteractor
import ru.payts.dragoman.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
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
