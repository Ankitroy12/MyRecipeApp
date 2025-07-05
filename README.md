# 🍲 Recipe App

A modern Android application to browse delicious recipes from an online API. Built using **MVVM architecture**, **Jetpack Compose UI**, and developed in **Android Studio**.

---

## 📱 Features

- 🍽️ View a list of recipes with images and titles
- 🧾 Detailed view with instructions and ingredients
- 🌐 Data fetched from a remote API (e.g. [TheMealDB](https://www.themealdb.com))
- ⚙️ Built with clean architecture using MVVM
- 🧩 Built with Jetpack Compose for modern, declarative UI
- 📶 Handles loading and error states gracefully

---

## 🧰 Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Kotlin |
| Architecture | MVVM (Model-View-ViewModel) |
| UI | Jetpack Compose |
| Network | Retrofit + Gson |
| Dependency Injection | Hilt *(optional)* |
| Development Environment | Android Studio |

---

## 📦 API Used

- **[TheMealDB API](https://www.themealdb.com/api.php)** for fetching recipe data
- Endpoints used:
  - `https://www.themealdb.com/api/json/v1/1/search.php?s=`
  - `https://www.themealdb.com/api/json/v1/1/lookup.php?i=`

---

## 🏗️ Architecture

- **Model**: Data classes representing recipes
- **View**: Composables displaying UI (stateless)
- **ViewModel**: Manages state and API calls, exposes `State` to Composables
- **Repository**: Handles data operations (API fetch)

---

