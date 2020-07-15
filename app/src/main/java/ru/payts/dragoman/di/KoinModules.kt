package ru.payts.dragoman.di

import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.datasource.RetrofitImplementation
import ru.payts.dragoman.model.datasource.RoomDataBaseImplementation
import ru.payts.dragoman.model.repository.Repository
import ru.payts.dragoman.model.repository.RepositoryImplementation
import ru.payts.dragoman.view.main.MainInteractor
import ru.payts.dragoman.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.payts.dragoman.di.NAME_LOCAL
import ru.payts.dragoman.di.NAME_REMOTE

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(RetrofitImplementation()) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(RoomDataBaseImplementation()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
