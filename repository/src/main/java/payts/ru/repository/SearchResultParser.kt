package payts.ru.repository

import payts.ru.model.data.DataModel
import payts.ru.model.data.SearchResult
import payts.ru.model.room.HistoryEntity

fun mapHistoryEntityToSearchResult(list: List<HistoryEntity>): List<SearchResult> {
    val searchResult = ArrayList<SearchResult>()
    if (!list.isNullOrEmpty()) {
        for (entity in list) {
            searchResult.add(SearchResult(entity.word, null))
        }
    }
    return searchResult
}

fun convertDataModelSuccessToEntity(dataModel: DataModel): HistoryEntity? {
    return when (dataModel) {
        is DataModel.Success -> {
            val searchResult = dataModel.data
            if (searchResult.isNullOrEmpty() || searchResult[0].text.isNullOrEmpty()) {
                null
            } else {
                HistoryEntity(searchResult[0].text!!, null)
            }
        }
        else -> null
    }
}
