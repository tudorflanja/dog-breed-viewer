# 🐶📱 Dog Breed Viewer – Android App (Kotlin + Jetpack Compose)

This mobile application displays dog breeds and their images using the **Dog CEO API**.  
It demonstrates clean Android development practices with **Kotlin**, **Jetpack Compose**, **MVVM**, and **Retrofit**, offering a smooth and intuitive UI for browsing dog breeds.

---

## 🚀 Features

- 🐕 **Dog Breed Browser** – View a complete list of dog breeds  
- 🖼️ **Image Gallery** – Display dog images fetched from the Dog CEO REST API  
- 🔎 **Search Bar** – Quickly find specific breeds through dynamic filtering  
- ⚡ **Modern UI Design** – Fully built with **Jetpack Compose**  
- 📡 **API Integration** – Real-time breed and image data via Retrofit  
- 🧭 **Navigation Component** – Seamless screen transitions  
- 💾 **Caching Ready** – Architecture supports offline storage extensions  
- 🎨 **Clean & Minimal UI** – Simple, smooth, and user-friendly  

---

## 🧰 Technologies Used

- **Kotlin** – Primary programming language  
- **Jetpack Compose** – Declarative UI toolkit  
- **Retrofit + Moshi** – Networking and JSON parsing  
- **MVVM Architecture** – ViewModel + Repository + UI layers  
- **Coroutines & Flow** – Asynchronous data handling  
- **Navigation Component** – Screen navigation  
- **Material 3** – Modern Android UI styling  
- **Android Studio (Kotlin DSL)** – Project setup and Gradle configuration  

---

## 🛠️ Application Overview

The app follows a clean and scalable architecture:

- **UI Layer** (Compose screens) – Breed lists, grids, and detail pages  
- **ViewModel Layer** – Holds UI state, exposes flows, and coordinates API calls  
- **Repository Layer** – Abstracts data access from UI  
- **Network Layer** – Retrofit client, endpoints, and JSON parsing  
- **Model Layer** – Kotlin data classes representing breed and image responses  

This modular structure ensures the project is readable, maintainable, and easy to extend.

---

## 📡 API Endpoints Used

The application interacts with the open-source **Dog CEO API**, which provides breed data and images.

- **List all breeds**  
  https://dog.ceo/api/breeds/list/all

- **Get images of a breed**  
  https://dog.ceo/api/breed/{breed}/images

- **Get images of a sub-breed**  
  https://dog.ceo/api/breed/{breed}/{subbreed}/images

Responses are returned as JSON and mapped using **Moshi**.

---

## 📂 Project Structure

| Path                            | Description                       |
| ------------------------------- | --------------------------------- |
| `app/`                          | Main Android module               |
| `app/src/main/java/ui/`         | Compose screens and components    |
| `app/src/main/java/viewmodel/`  | ViewModels                        |
| `app/src/main/java/repository/` | Data handling layer               |
| `app/src/main/java/network/`    | Retrofit API interfaces           |
| `app/src/main/java/model/`      | Data classes                      |
| `app/src/main/res/`             | Resources (icons, colors, themes) |
| `app/build.gradle.kts`          | App Gradle config                 |
| `media/`                        | Demo assets (optional)            |
| `build.gradle.kts`              | Project-wide Gradle config        |
| `settings.gradle.kts`           | Gradle module settings            |
| `.gitignore`                    | Git ignore rules                  |
| `README.md`                     | Documentation                     |

This structure ensures a solid separation of concerns and clean organization.

---

## ▶️ How to Run the Project

### 1️⃣ Clone the repository

    git clone https://github.com/tudorflanja/dog-breed-viewer.git
    cd dog-breed-viewer

### 2️⃣ Open the project

- Launch **Android Studio**  
- Select **Open**  
- Choose the **dog-breed-viewer** folder  

### 3️⃣ Sync Gradle

Android Studio will automatically download dependencies.

### 4️⃣ Run the app

- Select a device or emulator  
- Press **Run ▶️**  

The app will launch and display the list of dog breeds.

---

## 🧪 Testing Support

This project can be extended with:

- Unit tests (JUnit + Coroutines Test)  
- API tests (MockWebServer)  
- Compose UI tests (Compose Testing Framework)  

These can be added inside `src/test` and `src/androidTest`.

---

## 🌙 Optional: Dark Mode Support

Jetpack Compose enables effortless theming.  
Future improvements may include:

- Automatic system dark mode  
- Manual theme toggle  
- Dynamic color palettes using Material 3  

---

## 🚧 Future Improvements

Potential enhancements for upcoming versions:

- ⭐ Favorites system (save preferred dog images locally)  
- ⭐ Room database caching (offline mode)  
- ⭐ Pagination for large image sets  
- ⭐ Pull-to-refresh functionality  
- ⭐ More advanced filtering options  
- ⭐ Animations and loading indicators  

These improvements can significantly enhance user experience.

---

## 🙌 Acknowledgements

- **Dog CEO API** – Free and open dog image API  
- **Jetpack Compose Team** – Modern UI toolkit  
- **Android Developers Community** – Guides, samples, and libraries  

---

This project was completed for the User Interface Design course, as part of my studies at the Technical University of Cluj-Napoca (UTCN) 🎓.
