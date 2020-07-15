package ru.payts.dragoman.model.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
