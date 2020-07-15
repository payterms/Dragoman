package ru.payts.dragoman.model.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}
