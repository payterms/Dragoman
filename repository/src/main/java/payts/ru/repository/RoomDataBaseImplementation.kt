package payts.ru.repository

import payts.ru.model.data.DataModel
import payts.ru.model.data.SearchResult
import payts.ru.model.room.HistoryDao

class RoomDataBaseImplementation(private val historyDao: HistoryDao) : DataSourceLocal<List<SearchResult>> {

    override suspend fun getData(word: String): List<SearchResult> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(dataModel: DataModel) {
        convertDataModelSuccessToEntity(dataModel)?.let {
            historyDao.insert(it)
        }
    }
}
