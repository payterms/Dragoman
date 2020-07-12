package ru.payts.dragoman.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.payts.dragoman.view.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
