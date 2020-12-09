# BrowserStack

Automation project with Java + Gradle on Browser Stack and Github Action as a CI doing remote mobile test

![Appium Execution](https://github.com/tassioplima/automation-java-gradle/workflows/Gradle/badge.svg)


Configuration: 

- Java JDK 8 or 11
- Android SDK updated
- Android Emulator
- Appium Server
- Browser Stack Account and Keys

Running:

```
./gradlew test --tests "Tests"
```

You can run with different devices like iOS and Android using properties when running this command line:

Android: 

```
./gradlew test --tests "Tests" -DMOBILE=ANDROID
```

iOS: 

```
./gradlew test --tests "Tests" -DMOBILE=iOS
```
For Remote or Local execution you can run this command line:


```
./gradlew test --tests "Tests" -DMOBILE=ANDROID -DEXEC=REMOTE
```

```
./gradlew test --tests "Tests" -DMOBILE=ANDROID -DEXEC=LOCAL
```
