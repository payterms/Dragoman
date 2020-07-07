package ru.payts.dragoman.presenter

import ru.payts.dragoman.model.data.AppState
import ru.payts.dragoman.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}
