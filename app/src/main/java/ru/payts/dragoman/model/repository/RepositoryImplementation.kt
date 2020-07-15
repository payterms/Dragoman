package ru.payts.dragoman.model.repository

import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.datasource.DataSource
import ru.payts.dragoman.model.repository.Repository

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
