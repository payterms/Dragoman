package payts.ru.history.view.history

import payts.ru.core.viewmodel.Interactor
import payts.ru.model.data.DataModel
import payts.ru.model.data.SearchResult
import payts.ru.repository.Repository
import payts.ru.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResult>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResult>>
) : Interactor<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DataModel {
        return DataModel.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
