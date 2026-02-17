# Berlin clock

This Android app demonstrates the Berlin Clock, a unique, public timepiece installed in 1975 that tells time using 24 illuminated, colored fields arranged in five rows (seconds, 5-hour, 1-hour, 5-minute, and 1-minute blocks). Designed by Dieter Binninger, it was the first to use this "set theory" method, earning a spot in the Guinness Book of Records. 

# How to Read the Berlin Clock

The clock is read from top to bottom, with rows representing different time units:

- Top Row (Seconds): A single yellow light blinks on/off every two seconds.
- Second Row (5 Hours): Four red lights; each represents 5 hours.
- Third Row (1 Hour): Four red lights; each represents 1 hour.
- Fourth Row (5 Minutes): Eleven yellow/red lights; each represents 5 minutes (red indicates 15, 30, and 45 minutes).
- Bottom Row (1 Minute): Four yellow lights; each represents 1 minute.

# Example Calculation:
(e.g., 16:48):
- Hours: (3 lamps in 2nd row \(\times \) 5) + (1 lamp in 3rd row \(\times \) 1) = \(15+1=16\) hours.
- Minutes: (9 lamps in 4th row \(\times \) 5) + (3 lamps in 5th row \(\times \) 1) = \(45+3=48\) minutes.


## How to run

1. In Android Studio, create a new project by selecting the "Project from Version Control" option,
   then clone the project using the following repository link.

```
   https://github.com/2026-DEV2-043/BerlinClock.git
```

2. Once the Gradle sync is successful, proceed to run the app on either an emulator or a connected
   device. The minimum API level required is 24, and it has been tested against a device running
   Android 16.
   
3. You can also use the CLI to build and install the app using the following command.

```
 ./gradlew installDebug
```

## Tech Stack

- Kotlin
- Jetpack Compose
- MVVM + Clean architecture + TDD
- Material Design 3 components
- Coroutines + Flow for asynchronous
- StateFlow and ViewModel
- Dagger Hilt - Dependency Injection, HiltNavigationCompose
- Unit tests - JUnit, MockK
- Instrumentation tests - Espresso

## Screenshots

| 23:59.12                                                           | 00:00:07                                                           | 00:01:10                                                           | 16:59:08                                                           |
|--------------------------------------------------------------------|--------------------------------------------------------------------|--------------------------------------------------------------------|--------------------------------------------------------------------|
| <img src="screenshots/Screenshot_20260217_183520.png" width="200"> | <img src="screenshots/Screenshot_20260217_183922.png" width="200"> | <img src="screenshots/Screenshot_20260217_183756.png" width="200"> | <img src="screenshots/Screenshot_20260217_183839.png" width="200"> |