# Doctor Appointment App 🏥

An Android application built with Kotlin that allows users to browse doctors, view their profiles, and book appointments.

## 📱 Features

- Browse available doctors
- View detailed doctor profiles
- Book appointments with doctors
- View appointment confirmation
- Modern Material Design UI
- Navigation component for seamless user experience

## 🛠️ Tech Stack

- **Language**: Kotlin
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 35
- **Architecture Components**:
  - View Binding
  - Navigation Component (Fragment & UI)
- **UI Framework**: Material Design Components
- **Build System**: Gradle with Kotlin DSL

## 📦 Dependencies

- AndroidX Core KTX
- AndroidX AppCompat
- Material Components (1.9.0)
- ConstraintLayout
- Navigation Fragment KTX (2.6.0)
- Navigation UI KTX (2.6.0)

## 🏗️ Project Structure

```
app/
├── src/
│   └── main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/doctorappointmentapp/
│       │   ├── MainActivity.kt
│       │   ├── AppointmentActivity.kt
│       │   ├── DoctorProfileActivity.kt
│       │   └── ConfirmationActivity.kt
│       └── res/
└── build.gradle.kts
```

## 🚀 Getting Started

### Prerequisites

- Android Studio (Arctic Fox or newer)
- JDK 11 or higher
- Android SDK with API level 35

### Installation

1. Clone the repository
   ```bash
   git clone https://github.com/vanshjain99/DoctorAppointmentApp.git
   ```

2. Open the project in Android Studio

3. Sync the project with Gradle files

4. Run the app on an emulator or physical device

## 📝 Build Configuration

The app uses Gradle with Kotlin DSL for build configuration:

- **Application ID**: `com.example.doctorappointmentapp`
- **Version Code**: 1
- **Version Name**: 1.0
- **Java Compatibility**: VERSION_11
- **JVM Target**: 11

## 🎨 Activities

- **MainActivity**: Entry point of the application
- **AppointmentActivity**: Handles appointment booking
- **DoctorProfileActivity**: Displays detailed doctor information
- **ConfirmationActivity**: Shows appointment confirmation

## 🔧 Development

The project uses:
- View Binding for type-safe view access
- Navigation Component for fragment navigation
- Material Design for consistent UI/UX

## 📄 License

This project is currently unlicensed.

## 👤 Author

**vanshjain99**

- GitHub: [@vanshjain99](https://github.com/vanshjain99)

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

---

**Note**: This is an educational/personal project for learning Android development with Kotlin.