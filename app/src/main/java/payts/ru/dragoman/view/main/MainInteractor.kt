package payts.ru.Dragoman.view.main

import payts.ru.core.viewmodel.Interactor
import payts.ru.model.data.AppState
import payts.ru.model.data.dto.SearchResultDto
import payts.ru.repository.Repository
import payts.ru.repository.RepositoryLocal
import payts.ru.Dragoman.utils.mapSearchResultToResult

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}
