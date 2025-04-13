plugins {
    // Kotlin JVM plugin to add support for Kotlin
    kotlin("jvm") version "1.8.0"

    // Spring Boot plugin for packaging the application
    id("org.springframework.boot") version "3.0.0"

    // Dependency management plugin
    id("io.spring.dependency-management") version "1.0.15.RELEASE"

    // Kotlin Spring plugin to allow Kotlin specific extensions for Spring Boot
    kotlin("plugin.spring") version "1.8.0"

    // Application plugin to build a CLI application in Java
    application
}

repositories {
    // Use Maven Central for resolving dependencies
    mavenCentral()
}

dependencies {
    // спринг
    implementation("org.springframework.boot:spring-boot-starter-web")

    // тесты спринга
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // Kotlin standard libraries
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Add JUnit 5 dependency for testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    // Kotlin Test dependency (for `assertNotNull` and other Kotlin-specific tests)
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    
    // Guava library as an example (can be removed if not needed)
    implementation("com.google.guava:guava:31.0-jre")
}


java {
    // Use a specific Java toolchain for compatibility
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

application {
    // перезаписал 
    mainClass.set("org.example.HelloDockerSberRestKt")
}

tasks.named<Test>("test") {
    // Use JUnit platform for unit tests
    useJUnitPlatform()
}
