package payts.ru.repository

import payts.ru.model.data.DataModel

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(dataModel: DataModel)
}
