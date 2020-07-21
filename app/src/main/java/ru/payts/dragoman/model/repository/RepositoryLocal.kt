package ru.payts.dragoman.model.repository

import ru.payts.dragoman.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
