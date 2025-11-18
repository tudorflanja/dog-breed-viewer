package com.example.dogs

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

//Scop: Afișarea listei de rase și navigarea către un ecran detaliat pentru fiecare rasă.
//Cum funcționează:
//Datele sunt încărcate folosind DogViewModel.
//UI-ul este actualizat în funcție de starea de încărcare.
//Selectarea unei rase declanșează navigarea către un alt ecran.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                DogApp { breed ->
                    // Start BreedImageActivity with the selected breed
                    val intent = Intent(this, BreedImageActivity::class.java).apply {
                        putExtra("BREED_NAME", breed)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun DogApp(onBreedClick: (String) -> Unit = {}) {
    val viewModel: DogViewModel = viewModel()
    val isLoading by viewModel.isLoading.collectAsState()
    val dogBreeds by viewModel.dogBreeds.collectAsState()

    if (isLoading) {
        LoadingScreen()
    } else {
        DogListScreen(dogBreeds, onBreedClick)
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(16.dp))
            Text("Loading data. Please wait…")
        }
    }
}

@Composable
fun DogListScreen(dogBreeds: List<String>, onBreedClick: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(dogBreeds) { breed ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(vertical = 4.dp)
                    .clickable { onBreedClick(breed) }, // Trigger navigation on click
                elevation = 4.dp
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = breed,
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }
}
