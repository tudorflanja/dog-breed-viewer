# 🐶 DogBreedViewer – Android App for Exploring Dog Breeds

**DogBreedViewer** is a responsive and intuitive Android application developed in Kotlin that allows users to browse various dog breeds and view representative images. Built with clean architecture principles, the app leverages modern Android components and integrates seamlessly with a public API for real-time content.

## 🚀 Features

- 📋 Browse a dynamic list of dog breeds fetched via API
- 📸 View a representative image for each selected breed
- ⚡ Smooth and intuitive navigation between screens
- 🧼 Clean, minimal, and responsive UI
- 🔄 Asynchronous operations for fast loading

---

## 🧰 Technologies Used

- **Kotlin** – Primary language for Android development
- **MVVM Architecture** – Clear separation of UI and business logic
- **Retrofit** – For robust and scalable API interactions
- **ViewModel + LiveData** – To observe and update UI reactively
- **Coroutines** – For structured concurrency and async operations
- **Intents** – For activity navigation

---

## 📦 Project Structure

- `MainActivity.kt` – Displays the list of dog breeds
- `BreedImageActivity.kt` – Shows the image of the selected breed
- `DogViewModel.kt` – Exposes observable data to the UI
- `DogApiService.kt` – Defines Retrofit API interface
- `DogResponse.kt` – Data model for parsing API responses

---

## 📡 API Integration

This app uses the public [Dog CEO's Dog API](https://dog.ceo/dog-api/) to retrieve:
- The full list of dog breeds
- A random image associated with each breed

---

## 📝 Conclusion

**DogBreedViewer** is a simple yet powerful example of modern Android development using best practices such as MVVM, coroutines, and clean architecture. It serves as a great starting point for projects involving dynamic data loading, RESTful API integration, and responsive UI design on mobile platforms.
