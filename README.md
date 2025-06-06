# 🐶 DogBreedViewer

DogBreedViewer is a sleek Android application built with Kotlin that allows users to browse different dog breeds and view representative images. The app uses a clean MVVM architecture and integrates with a public dog breed API to display dynamic content.

## 🚀 Features

- Browse a list of dog breeds fetched from a public API
- Tap on a breed to view an image of that breed
- Simple and responsive user interface
- Clean navigation between screens
- Built using modern Android development practices

## 🛠️ Technologies Used

- **Kotlin** – Modern Android development language
- **MVVM Architecture** – Separation of concerns for scalable code
- **Retrofit** – For network/API calls
- **ViewModel + LiveData** – For reactive UI updates
- **Coroutines** – For asynchronous operations
- **Intents** – For screen navigation

## 📦 Project Structure

- `MainActivity.kt` – Displays the list of breeds
- `DogViewModel.kt` – Handles data logic and exposes LiveData
- `DogApiService.kt` – Retrofit API client
- `BreedImageActivity.kt` – Displays image of the selected breed
- `DogResponse.kt` – Data class for API response

## 📡 API Reference

This project uses the [Dog CEO's Dog API](https://dog.ceo/dog-api/) to fetch breed data and images.
