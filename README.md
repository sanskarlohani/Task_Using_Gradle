# Kotlin Structure Plugin 🧩

A lightweight **Gradle plugin** that adds a task to analyze **Kotlin source files** and print their basic structure (packages, classes, functions).  
The plugin activates **only if the Kotlin Gradle Plugin is applied**, making it safe to include in mixed-language projects.

---

## 🚀 Features

- ✅ Detects and prints:
  - Kotlin `package` statements
  - Top-level `class` declarations
  - Top-level `fun` declarations
- 🧠 Activates only when the Kotlin plugin is present
- 🧪 Includes a test using JUnit 5 and Gradle TestKit

---

## 📦 How to Use

### 1. Apply the Plugin

In your `build.gradle.kts`:

```kotlin
plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("com.example.kotlin-structure") // Replace with your actual plugin ID
}
```

### 2. Run the Task

```bash
./gradlew analyzeKotlinStructure
```

### 🧾 Sample Output

```
Kotlin Source Structure:
File: Hello.kt
  Package: package com.example
  Class: class Hello {
  Function:     fun greet() = "Hello"
```

---

## 🧪 Running Tests

To verify plugin functionality:

```bash
./gradlew test
```

The included test creates a temporary Kotlin project, applies the plugin, and asserts output correctness.

---

## 🗂️ Project Structure

```
.
├── build.gradle.kts
├── settings.gradle.kts
├── src
│   ├── main/kotlin/com/example/KotlinStructurePlugin.kt
│   └── test/kotlin/com/example/KotlinStructurePluginTest.kt
```

---

## ⚠️ Limitations

- This is a **basic line-based structure parser**.
- It doesn’t handle:
  - Nested functions/classes
  - Multiline declarations
  - Advanced syntax (sealed classes, objects, etc.)

---

## 🛠️ Possible Improvements

- Use Kotlin compiler API for deeper analysis
- Output to a file or JSON
- Allow filtering or configuration options
- Support nested structures or visibility modifiers

---

## 📄 License

MIT – Free to use, modify, and share.

---

## 🙌 Acknowledgments

Inspired by common Gradle plugin patterns and Kotlin Gradle Plugin APIs.  
Perfect for practice and small utilities.
