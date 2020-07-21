package payts.ru.repository

import payts.ru.model.data.DataModel
import payts.ru.model.data.SearchResult

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<SearchResult>>) :
    RepositoryLocal<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(dataModel: DataModel) {
        dataSource.saveToDB(dataModel)
    }
}
