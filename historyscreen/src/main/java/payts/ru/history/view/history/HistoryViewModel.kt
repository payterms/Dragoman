package payts.ru.history.view.history

import androidx.lifecycle.LiveData
import payts.ru.core.viewmodel.BaseViewModel
import payts.ru.history.parseLocalSearchResults
import payts.ru.model.data.DataModel
import kotlinx.coroutines.launch

class HistoryViewModel(private val interactor: HistoryInteractor) :
    BaseViewModel<DataModel>() {

    private val liveDataForViewToObserve: LiveData<DataModel> = _mutableLiveData

    fun subscribe(): LiveData<DataModel> {
        return liveDataForViewToObserve
    }

    override fun getData(word: String, isOnline: Boolean) {
        _mutableLiveData.value = DataModel.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch { startInteractor(word, isOnline) }
    }

    private suspend fun startInteractor(word: String, isOnline: Boolean) {
        _mutableLiveData.postValue(parseLocalSearchResults(interactor.getData(word, isOnline)))
    }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(DataModel.Error(error))
    }

    override fun onCleared() {
        _mutableLiveData.value = DataModel.Success(null)//TODO Workaround. Set View to original state
        super.onCleared()
    }
}
