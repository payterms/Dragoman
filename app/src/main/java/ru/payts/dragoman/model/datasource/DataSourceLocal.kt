package ru.payts.dragoman.model.datasource

import ru.payts.dragoman.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
