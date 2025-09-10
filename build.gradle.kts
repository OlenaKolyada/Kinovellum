plugins {
    kotlin("jvm") apply false
}

group = "com.funkycorgi.rustydeck"
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