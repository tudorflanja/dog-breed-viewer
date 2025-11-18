package com.example.dogs

import retrofit2.http.GET
import retrofit2.http.Path

interface BreedImageApi { // definește endpoint-ul API pentru imaginile raselor.
    @GET("breed/{breed}/images")
    suspend fun getBreedImages(@Path("breed") breed: String): BreedImagesResponse
}

data class BreedImagesResponse( //  răspunsul API, transformând JSON-ul într-un format ușor de utilizat în Kotlin.
    val message: List<String>,
    val status: String
)
