package ru.payts.dragoman.view.main

import ru.payts.dragoman.model.data.AppState
import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.repository.Repository
import ru.payts.dragoman.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
