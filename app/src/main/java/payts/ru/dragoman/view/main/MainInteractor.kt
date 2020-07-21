package payts.ru.dragoman.view.main

import payts.ru.core.viewmodel.Interactor
import payts.ru.model.data.DataModel
import payts.ru.model.data.SearchResult
import payts.ru.repository.Repository
import payts.ru.repository.RepositoryLocal

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResult>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResult>>
) : Interactor<DataModel> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): DataModel {
        val dataModel: DataModel
        if (fromRemoteSource) {
            dataModel = DataModel.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(dataModel)
        } else {
            dataModel = DataModel.Success(repositoryLocal.getData(word))
        }
        return dataModel
    }
}
