# User Management Android App

An Android application demonstrating user storage and retrieval using Room database, built with Clean Architecture principles and latest Android development practices.

## 🏗️ Architecture

This project follows **Clean Architecture** principles with clear separation of concerns:

```
app/
├── data/           # Data layer (Room DB, Repositories)
├── domain/         # Business logic (Use cases, Entities)
├── presentation/   # UI layer (Fragments, ViewModels)
└── di/            # Dependency Injection (Hilt modules)
```

## 🛠️ Tech Stack

- **Kotlin** - Primary programming language
- **Room Database** - Local data persistence
- **Hilt/Dagger** - Dependency injection
- **Navigation Component** - Single Activity navigation
- **MVVM Pattern** - Presentation layer architecture
- **Coroutines & Flow** - Asynchronous programming
- **View Binding** - Type-safe view references


## 📦 Modular Structure

### Data Layer (`data/`)
- `database/` - Room database, DAOs, entities
- `repository/` - Repository implementations
- `mapper/` - Data transformations

### Domain Layer (`domain/`)
- `model/` - Domain entities
- `repository/` - Repository interfaces
- `usecase/` - Business logic use cases

### Presentation Layer (`presentation/`)
- `fragment/` - UI fragments
- `viewmodel/` - ViewModels for UI state management
- `adapter/` - RecyclerView adapters

## 🔧 SOLID Principles Applied

1. **Single Responsibility Principle (SRP)**
   - Each class has one reason to change
   - Use cases handle single business operations
   - ViewModels manage single screen state

2. **Open/Closed Principle (OCP)**
   - Repository pattern allows extension without modification
   - Use case interfaces enable easy testing

3. **Liskov Substitution Principle (LSP)**
   - Repository implementations are interchangeable

4. **Interface Segregation Principle (ISP)**
   - Small, focused interfaces for repositories and use cases

5. **Dependency Inversion Principle (DIP)**
   - High-level modules depend on abstractions
   - Hilt provides dependency injection

## 🚀 Features

- ✅ Add new users with validation
- ✅ View all users in a list

## 📱 Navigation Flow

```
MainActivity (Single Activity)
├── AddUserFragment (Home)
└── UsersFragment
```




https://github.com/user-attachments/assets/28c76aff-6752-440f-ba79-8859217c8052

