plugins {
    kotlin("jvm") apply false
}

group = "com.funkycorgi.kinovellum"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    group = rootProject.group
    version = rootProject.version
}