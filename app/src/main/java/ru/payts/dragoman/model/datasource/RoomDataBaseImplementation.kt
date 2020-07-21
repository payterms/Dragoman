package ru.payts.dragoman.model.datasource

import ru.payts.dragoman.model.data.AppState
import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.room.HistoryDao
import ru.payts.dragoman.utils.convertDataModelSuccessToEntity
import ru.payts.dragoman.utils.mapHistoryEntityToSearchResult
import ru.payts.dragoman.model.datasource.DataSourceLocal

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
