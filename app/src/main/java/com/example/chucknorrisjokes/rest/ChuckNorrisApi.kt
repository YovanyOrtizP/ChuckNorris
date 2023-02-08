package com.example.chucknorrisjokes.rest

import com.example.chucknorrisjokes.model.ChuckNorrisResponse
import retrofit2.Response
import retrofit2.http.GET

interface ChuckNorrisApi {
    @GET(RANDOM)
    suspend fun getJoke(): Response<ChuckNorrisResponse>

    companion object {
        //https://api.chucknorris.io/
        //https://api.chucknorris.io/jokes/random
        const val BASE_URL = "https://api.chucknorris.io"
        const val RANDOM = "/jokes/random"
        const val CATEGORIES = "categories"
    }
}
