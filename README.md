# Doctor Appointment App 🏥

An Android application built with Kotlin that allows users to browse doctors, view their profiles, and book appointments.

## 📱 Features

- Browse available doctors
- View detailed doctor profiles
- Book appointments with doctors
- View appointment confirmation
- Modern Material Design UI
- Navigation component for seamless user experience

## 📱 Screenshots

<img width="200" alt="Screenshot_20250404_181439" src="https://github.com/user-attachments/assets/77d1edc7-2428-421e-9e05-6a6f71943774" />
<img width="200" alt="Screenshot_20250404_181300" src="https://github.com/user-attachments/assets/aa8d9a17-2bcf-42f9-bb04-39b26953484c" />
<img width="200" alt="Screenshot_20250404_181313" src="https://github.com/user-attachments/assets/a8d641de-6b9f-47cd-b430-bca9195ffd29" />
<img width="200" alt="Screenshot_20250404_181323" src="https://github.com/user-attachments/assets/1c600046-233f-4b3f-adcf-c94691998375" />
<img width="200" alt="Screenshot_20250404_181341" src="https://github.com/user-attachments/assets/d5eecfd6-6f72-4305-a19a-05a447db689a" />
<img width="200" alt="Screenshot_20250404_181355" src="https://github.com/user-attachments/assets/54fdd6cc-58da-4554-8d87-afd660c09587" />
<img width="200" alt="Screenshot_20250404_181409" src="https://github.com/user-attachments/assets/6100339f-1081-4bff-9e6f-62fd8eab51eb" />
<img width="200" alt="Screenshot_20250404_181417" src="https://github.com/user-attachments/assets/dd7c92cc-868b-462f-a419-ea9969cf4313" />




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
