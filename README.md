# AndroidDemoEspresso

[![Circle
CI](https://circleci.com/gh/circleci/EspressoSample.svg?style=svg)](https://circleci.com/gh/JencirJamal)

A sample android application that showcases different Espresso Automation features like
 - ActivityTestRule
 - GrantPermissionRule
 - IdlingResource
 - InstrumentationRegistry, etc
 
 The project is also deployed in CircleCi continous integration tool.

## Structure:

- `app/` - Main application
- `app/test/` - Unit tests
- `app/androidTest/` - Instrumentation tests

## Running Instrumentation Tests

### In Android Studio
- In the *Build Variants* window, make sure the *Android Instrumentation Tests* option is selected.
- Open a Instrumentation test class like `EspressoTest.java` or `UiAutomatorTest.java`
- Right click on the class and *Run* as Android Test.

### From command-line via Gradle
- To run all the Instrumentation tests in the `app` module execute:

``` sh
./gradlew app:connectedAndroidTest
```

### From command-line via adb
- Install the app and the test app on the device. For example:

``` sh
./gradlew app:installFlavor2Debug app:installFlavor2DebugAndroidTest
```

- To run the Instrumentation tests in the `app` module execute:

``` sh
adb shell am instrument -w com.example.android.testing.blueprint.flavor2.test/android.support.test.runner.AndroidJUnitRunner
```

See the [Modules](#modules), and custom [Gradle command-line arguments](#custom-gradle-command-line-arguments) sections to learn how to execute tests for specific modules and pass custom arguments to AndroidJUnitRunner.

## Testing frameworks and APIs

### Espresso
Espresso is a part of the ATSL (Android Testing Support Library) and a framework for writing concise, beautiful, and reliable Android UI tests.

