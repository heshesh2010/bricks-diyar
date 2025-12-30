# Android MVVM Module Brick

A [Mason](https://github.com/felangel/mason) brick to generate Android Kotlin MVVM feature modules with clean architecture.

## Features

- 🏗️ Complete MVVM architecture setup
- 📦 Models, Services, Repositories, ViewModels, and Views
- 🔄 Support for Kotlin Flow or LiveData
- 🎨 Customizable layers (Service, Repository)
- 🚀 Ready-to-use template structure
- 📱 Fragment-based views with RecyclerView support

## Usage

```sh
mason make android_mvvm_module
```

## Variables

| Variable | Description | Default | Type |
|----------|-------------|---------|------|
| `name` | The name of your feature module | - | string |
| `hasService` | Include a service layer for API calls | true | boolean |
| `hasRepository` | Include a repository layer | true | boolean |
| `useFlow` | Use Kotlin Flow for reactive programming | true | boolean |
| `useLiveData` | Use LiveData instead of Flow | false | boolean |

## Structure

```
features/
  └── YourFeature/
      ├── models/
      │   └── YourFeature.kt
      ├── services/ (optional)
      │   └── YourFeatureService.kt
      ├── repositories/ (optional)
      │   ├── YourFeatureRepository.kt
      │   └── YourFeatureRepositoryImpl.kt
      ├── viewmodels/
      │   └── YourFeatureViewModel.kt
      └── views/
          ├── YourFeatureListView.kt
          └── YourFeatureDetailView.kt
```

## Example

Generate a User feature module:

```sh
mason make android_mvvm_module --name user --hasService true --hasRepository true --useFlow true
```

This will create:
- `User.kt` model
- `UserService.kt` for API calls
- `UserRepository.kt` and `UserRepositoryImpl.kt` for data layer
- `UserViewModel.kt` with Flow-based state management
- `UserListView.kt` and `UserDetailView.kt` for UI

## Dependencies

Make sure your Android project has the following dependencies:

```gradle
// ViewModel
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2"

// For Flow (if useFlow is true)
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3"

// For LiveData (if useLiveData is true)
implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.2"

// Retrofit for network calls
implementation "com.squareup.retrofit2:retrofit:2.9.0"
implementation "com.squareup.retrofit2:converter-gson:2.9.0"

// Koin for dependency injection
implementation "io.insert-koin:koin-android:3.5.0"
```

## License

MIT
