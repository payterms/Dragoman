package ru.payts.dragoman.di

import dagger.Module
import dagger.Provides
import ru.payts.dragoman.model.data.DataModel
import ru.payts.dragoman.model.repository.Repository
import ru.payts.dragoman.view.main.MainInteractor
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
