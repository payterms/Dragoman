package ru.payts.dragoman.model.repository

import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.datasource.DataSource
import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}
