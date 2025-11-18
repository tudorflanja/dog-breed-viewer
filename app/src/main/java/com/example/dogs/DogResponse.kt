package com.example.dogs //este o clasă simplă, dar esențială pentru a structura și manipula
// datele primite de la API-ul de rase de câini. Transformă JSON-ul brut într-un format ușor de utilizat în Kotlin.

data class DogResponse(
    val message: Map<String, List<String>>,
    val status: String
)
