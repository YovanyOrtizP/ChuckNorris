package com.example.chucknorrisjokes.utils

import com.example.chucknorrisjokes.model.domain.DomainJokes

sealed class UIState {
    //It's necessary because you will show the steps we are doing in the UI.
    object LOADING : UIState()
    data class SUCCESS(val response: DomainJokes) : UIState()
    class ERROR(val e: Exception) : UIState()
}