package ru.payts.dragoman.view.base

import ru.payts.dragoman.model.data.AppState

interface View {

    fun renderData(appState: AppState)

}
