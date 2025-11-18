package com.example.dogs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import coil.compose.rememberImagePainter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel

//Acest cod implementează afișarea imaginilor unei rase selectate:
//
//Folosește Jetpack Compose pentru UI.
//ViewModel pentru gestionarea datelor și a stării.
//Integrarea cu API-ul este gestionată de Retrofit.

class BreedImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val breedName = intent.getStringExtra("BREED_NAME") ?: ""
        setContent {
            MaterialTheme {
                BreedImageScreen(breedName)
            }
        }
    }
}

// ViewModel for Fetching Images
class BreedImageViewModel : ViewModel() {
    private val _images = mutableStateOf<List<String>>(emptyList())
    val images: List<String> get() = _images.value

    private val _isLoading = mutableStateOf(true)
    val isLoading: Boolean get() = _isLoading.value

    fun fetchBreedImages(breed: String) {
        viewModelScope.launch {
            _isLoading.value = true
            delay(2000) // Simulate loading delay
            try {
                val response = ApiClient.breedImageApi.getBreedImages(breed)
                _images.value = response.message
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
}

// Breed Image Screen
@Composable
fun BreedImageScreen(breedName: String) {
    val viewModel = remember { BreedImageViewModel() }
    var showAllImages by remember { mutableStateOf(false) } // State to display all images

    // Fetch breed images
    LaunchedEffect(Unit) {
        viewModel.fetchBreedImages(breedName)
    }

    if (viewModel.isLoading) {
        // Show loading animation
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(16.dp))
                Text("Loading images. Please wait...")
            }
        }
    } else {
        // Show images and Load All button
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Display first 6 images or all images based on the button press
            val imagesToShow = if (showAllImages) viewModel.images else viewModel.images.take(6)

            items(imagesToShow) { imageUrl ->
                Image(
                    painter = rememberImagePainter(imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(vertical = 8.dp)
                )
            }

            // Show "Load Images" button if not all images are shown
            if (!showAllImages) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = {
                            showAllImages = true // Show all images
                        }) {
                            Text("Load all images")
                        }
                    }
                }
            }
        }
    }
}
