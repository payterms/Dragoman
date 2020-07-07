package ru.payts.dragoman.view.main

import com.anikin.aleksandr.simplevocabulary.viewmodel.Interactor
import ru.payts.dragoman.model.data.AppState
import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.repository.Repository
import io.reactivex.Observable

class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}
