package com.example.chucknorrisjokes.rest

import com.example.chucknorrisjokes.model.domain.DomainJokes
import com.example.chucknorrisjokes.model.domain.mapToDomainJoke
import com.example.chucknorrisjokes.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface ChuckNorrisRepository {
    //Flow es como un observable
    //es un fata tiepe que emite datos constantemente y alguien los esta escuchando
    //flow es un observable, lo que hace es emitir datos y quien este escuchando los datos va a reaccionar a eso
    //state fow necesita un valor por default, es un hot flow, listo para ser emitido

    //Este es un code flow, es decir, esta por pedir y generar los datos.

    //Si tu creas la clase, cualquier persona que necesite el repositorio, va a poder modificar la implementacion
    fun getRandomJoke(): Flow<UIState>
}

class ChuckNorrisRepositoryImpl @Inject constructor(
    private val chuckNorrisApi: ChuckNorrisApi
) : ChuckNorrisRepository{

    override fun getRandomJoke(): Flow<UIState> = flow {
        emit(UIState.LOADING)
        try{
            val response = chuckNorrisApi.getJoke()
            if (response.isSuccessful){
                response.body()?.let {
                    //Se manda la funcion creada en el Domain Class
                    emit(UIState.SUCCESS(it.mapToDomainJoke()))
                }?: throw Exception("Null joke")
            }else{
                throw Exception(response.errorBody()?.string())
            }
        }catch (e: Exception){
            emit(UIState.ERROR(e))
        }
    }

}