package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project

class KotlinStructurePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.afterEvaluate {
            if (project.plugins.hasPlugin("org.jetbrains.kotlin.jvm")) {
                project.tasks.register("analyzeKotlinStructure") {
                    group = "verification"
                    description = "Outputs the structure of Kotlin source files."

                    doLast {
                        val sourceDirs = project.fileTree("src") {
                            include("**/*.kt")
                        }.files

                        println("Kotlin Source Structure:")

                        sourceDirs.forEach { file ->
                            println("File: ${file.name}")
                            file.readLines().forEach { line ->
                                when {
                                    line.trim().startsWith("package ") -> println("  Package: $line")
                                    line.trim().startsWith("class ") -> println("  Class: $line")
                                    line.trim().startsWith("fun ") -> println("  Function: $line")
                                }
                            }
                        }
                    }
                }
            } else {
                project.logger.lifecycle("Kotlin plugin not found. Task 'analyzeKotlinStructure' will not be registered.")
            }
        }
    }
}
