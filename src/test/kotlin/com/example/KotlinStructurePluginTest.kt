package com.example

import org.gradle.testkit.runner.GradleRunner
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.io.File

class KotlinStructurePluginTest {

    @TempDir
    lateinit var testProjectDir: File

    @Test
    fun `plugin should analyze kotlin files`() {
        // Write settings.gradle.kts
        File(testProjectDir, "settings.gradle.kts").writeText("rootProject.name = \"test-project\"")

        // Write build.gradle.kts
        File(testProjectDir, "build.gradle.kts").writeText(
            """
            plugins {
                id("org.jetbrains.kotlin.jvm") version "1.9.0"
                id("com.example.kotlin-structure")
            }

            repositories {
                mavenCentral()
            }
            """.trimIndent()
        )

        // Create a source file
        val srcDir = File(testProjectDir, "src/main/kotlin/com/example")
        srcDir.mkdirs()
        File(srcDir, "Hello.kt").writeText(
            """
            package com.example

            class Hello {
                fun greet() = "Hello"
            }
            """.trimIndent()
        )

        // Run the task
        val result = GradleRunner.create()
            .withProjectDir(testProjectDir)
            .withArguments("analyzeKotlinStructure")
            .withPluginClasspath()
            .build()

        println("Plugin output:\n${result.output}")

        assertTrue(result.output.contains("Class:") && result.output.contains("class Hello"))
        assertTrue(result.output.contains("Function:") && result.output.contains("fun greet"))
    }
}
