package com.example.chucknorrisjokes.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorrisjokes.rest.ChuckNorrisRepository
import com.example.chucknorrisjokes.viewmodel.ChuckNorrisViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


class ChuckNorrisViewModelFactory @Inject constructor(
    private val chuckNorrisRepository: ChuckNorrisRepository,
    private val ioDispatcher: CoroutineDispatcher
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ChuckNorrisViewModel(chuckNorrisRepository,ioDispatcher) as T
    }
}

