package com.example.chucknorrisjokes.rest

import com.example.chucknorrisjokes.model.ChuckNorrisResponse
import retrofit2.Response
import retrofit2.http.GET

interface ChuckNorrisApi {
    @GET(RANDOM)
    fun getJoke(): Response<ChuckNorrisResponse>

    companion object {
        //https://api.chucknorris.io/jokes/random
        //https://api.chucknorris.io/jokes/
        const val BASE_URL = "https://api.chucknorris.io/jokes/"
        const val RANDOM = "random"
        const val CATEGORIES = "categories"
    }
}
