package com.example.chucknorrisjokes.di

import android.app.Application
import android.content.Context
import com.example.chucknorrisjokes.rest.ChuckNorrisRepository
import com.example.chucknorrisjokes.utils.ChuckNorrisViewModelFactory
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    fun providesContext(): Context =
        application.applicationContext

    @Provides
    fun providesViewModelFactory(
        repository: ChuckNorrisRepository,
        ioDispatcher: CoroutineDispatcher
    ): ChuckNorrisViewModelFactory = ChuckNorrisViewModelFactory(repository,ioDispatcher)
}

