package com.example.chucknorrisjokes.di

import android.app.Application

//Se debe mandar a llamar en el Manifest
class ChuckNorrisApp : Application() {

    override fun onCreate() {
        super.onCreate()
        chuckNorrisComponent = DaggerChuckNorrisComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var chuckNorrisComponent: ChuckNorrisComponent
    }
}


//// Dagger + StarWarsComponent
////Es en compile time
//starWarsComponent = DaggerStarWarsComponent
//.builder()
//.applicationModule(ApplicationModule(this))
//.build()
//}
//
//companion object {
//    lateinit var starWarsComponent: StarWarsComponent
//}