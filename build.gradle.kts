plugins {
    kotlin("jvm") version "2.0.21"
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions.jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    sourceSets.main { kotlin.srcDir("app/src/main/java") }
    sourceSets.test { kotlin.srcDir("app/src/test/java") }
}

sourceSets.test {
    resources.srcDir("mock-fixtures/fixtures")
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.code.gson:gson:2.10.1")
}
