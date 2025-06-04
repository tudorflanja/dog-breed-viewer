package com.example.dogs

data class DogResponse(
    val message: Map<String, List<String>>,
    val status: String
)
