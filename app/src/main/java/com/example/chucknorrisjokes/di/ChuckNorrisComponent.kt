package com.example.chucknorrisjokes.di

import com.example.chucknorrisjokes.MainActivity
import com.example.chucknorrisjokes.ui.DisplayJoke
import dagger.Component


@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        ApplicationModule::class
    ]
)
interface ChuckNorrisComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(displayJoke: DisplayJoke)
}