package ru.payts.dragoman.view.main

import ru.payts.dragoman.di.NAME_REMOTE
import ru.payts.dragoman.model.data.AppState
import ru.payts.dragoman.di.NAME_LOCAL
import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.repository.Repository
import ru.payts.dragoman.viewmodel.Interactor
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}
