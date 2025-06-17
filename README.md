# BMI Buddy

A modern Android application that helps users calculate their Body Mass Index (BMI) and provides health recommendations based on the results.

## Features

- Input fields for height (cm) and weight (kg)
- Real-time BMI calculation
- Visual feedback with color-coded results
- Health recommendations based on BMI category
- Dark mode support
- Material Design UI components
- Animated loading indicator
- Reset functionality

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture pattern:

- **Model**: Data classes and enums for BMI calculation and categorization
- **View**: XML layouts and Activity for UI representation
- **ViewModel**: Handles business logic and data management

## Tech Stack

- Kotlin
- Android SDK
- Material Design Components
- ViewModel and LiveData
- ViewBinding
- Lottie for animations
- JUnit4 for unit testing
- Mockito for mocking in tests

## Building and Running

1. Clone the repository:
```bash
git clone https://github.com/yourusername/bmi-buddy.git
```

2. Open the project in Android Studio

3. Sync the project with Gradle files

4. Run the app on an emulator or physical device

## Running Tests

To run the unit tests:

1. Open the project in Android Studio
2. Right-click on the `test` directory
3. Select "Run Tests"

Or use the command line:
```bash
./gradlew test
```

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/ideas2it/bmicalculator/
│   │   │   ├── MainActivity.kt
│   │   │   ├── model/
│   │   │   │   └── BmiResult.kt
│   │   │   └── viewmodel/
│   │   │       └── BmiViewModel.kt
│   │   └── res/
│   │       ├── layout/
│   │       │   └── activity_main.xml
│   │       └── raw/
│   │           └── loading_animation.json
│   └── test/
│       └── java/com/ideas2it/bmicalculator/
│           └── viewmodel/
│               └── BmiViewModelTest.kt
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Material Design Components for the UI elements
- Lottie for the loading animation
- Android Architecture Components for MVVM implementation 