plugins {
    kotlin("jvm") apply false
}

group = "com.funkycorgi.kinovellum"
version = "0.0.1"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    group = rootProject.group
    version = rootProject.version
}