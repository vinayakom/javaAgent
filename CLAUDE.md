# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run Commands

```bash
# Build the project
./gradlew build

# Run the application
./gradlew run

# Run all tests
./gradlew test

# Run a single test class
./gradlew test --tests "org.example.YourTestClass"

# Run a single test method
./gradlew test --tests "org.example.YourTestClass.yourTestMethod"

# Clean build artifacts
./gradlew clean

# Build JAR
./gradlew jar
# Output: build/libs/javaAgent-1.0-SNAPSHOT.jar
```

## Project Structure

- **Language**: Java, built with Gradle (Groovy DSL)
- **Group**: `org.example`
- **Test framework**: JUnit Jupiter (JUnit 5)
- **Source root**: `src/main/java/org/example/`
- **Test root**: `src/test/java/org/example/` (to be created)
- **Main class**: `org.example.Main`