package payts.ru.history.view.history

import payts.ru.core.viewmodel.Interactor
import payts.ru.model.data.AppState
import payts.ru.model.data.DataModel
import payts.ru.repository.Repository
import payts.ru.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
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
