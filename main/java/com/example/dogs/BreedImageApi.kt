package com.example.dogs

import retrofit2.http.GET
import retrofit2.http.Path

interface BreedImageApi {
    @GET("breed/{breed}/images")
    suspend fun getBreedImages(@Path("breed") breed: String): BreedImagesResponse
}

data class BreedImagesResponse(
    val message: List<String>,
    val status: String
)
