package com.example.chucknorrisjokes.model.domain

import com.example.chucknorrisjokes.model.ChuckNorrisResponse

data class DomainJokes(
    val jokesValues: String
)

//domain es para mas clean architecture
//separacion de concerns
//un modelo para json y otro para lo que voy a utilizar

//Crear extension function para cambiar del chuck norris response al domain data

//crear o agregar funcionalidad a la clase sin necesidad de extender toda la clase
//Siempre que se cambia de un response a un domain class se debe realizar una extension function
// igualas el valor o valores de tu domain class con los valores de tu response.
fun ChuckNorrisResponse.mapToDomainJoke(): DomainJokes {
    return DomainJokes(
        jokesValues = this.value ?: "Joke not found"
    )
}
//Domain Data