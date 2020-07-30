package payts.ru.history.view.history

import payts.ru.core.viewmodel.Interactor
import payts.ru.model.data.AppState
import payts.ru.model.data.dto.SearchResultDto
import payts.ru.repository.Repository
import payts.ru.repository.RepositoryLocal
import payts.ru.Dragoman.utils.mapSearchResultToResult

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
