package com.example.dogs

import retrofit2.http.GET

interface DogApiService {
    @GET("breeds/list/all")
    suspend fun getDogBreeds(): DogResponse
}


