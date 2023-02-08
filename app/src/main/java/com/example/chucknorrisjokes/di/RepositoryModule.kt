package com.example.chucknorrisjokes.di

import com.example.chucknorrisjokes.rest.ChuckNorrisRepository
import com.example.chucknorrisjokes.rest.ChuckNorrisRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun provideChuckNorrisRepository(
        chuckNorrisRepositoryImpl: ChuckNorrisRepositoryImpl
    ): ChuckNorrisRepository
}