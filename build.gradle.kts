plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
    kotlin("jvm") version "1.9.0"
}

group = "com.example"
version = "1.0"

gradlePlugin {
    plugins {
        create("kotlinStructurePlugin") {
            id = "com.example.kotlin-structure"
            implementationClass = "com.example.KotlinStructurePlugin"
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(gradleTestKit())
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}