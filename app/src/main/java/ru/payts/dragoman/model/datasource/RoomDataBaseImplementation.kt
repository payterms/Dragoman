package ru.payts.dragoman.model.datasource

import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.datasource.DataSource

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
