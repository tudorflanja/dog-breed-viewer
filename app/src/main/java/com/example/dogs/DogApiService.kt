package com.example.dogs

import retrofit2.http.GET

//DogApiService definește endpoint-ul API pentru obținerea listei de rase.
//Este folosit de ApiClient pentru a face apeluri API.
//Retrofit automatizează gestionarea cererilor și conversia datelor JSON în obiecte Kotlin
interface DogApiService {
    @GET("breeds/list/all")
    suspend fun getDogBreeds(): DogResponse
}


