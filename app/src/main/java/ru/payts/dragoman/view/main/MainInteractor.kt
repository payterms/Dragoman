package ru.payts.dragoman.view.main

import ru.payts.dragoman.model.data.AppState
import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.repository.Repository
import ru.payts.dragoman.model.repository.RepositoryLocal
import ru.payts.dragoman.viewmodel.Interactor

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}
