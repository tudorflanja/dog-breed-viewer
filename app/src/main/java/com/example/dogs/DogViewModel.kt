package com.example.dogs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

//gestionează logica de încărcare a datelor pentru lista de rase.
class DogViewModel : ViewModel() {
    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _dogBreeds = MutableStateFlow<List<String>>(emptyList())
    val dogBreeds: StateFlow<List<String>> = _dogBreeds

    init {
        loadDogBreeds()
    }

    private fun loadDogBreeds() {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000) // Simulate loading delay
            try {
                val response = ApiClient.dogApiService.getDogBreeds()
                _dogBreeds.value = response.message.keys.toList()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
