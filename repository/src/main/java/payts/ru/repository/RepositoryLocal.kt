package payts.ru.repository

import payts.ru.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
