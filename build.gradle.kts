plugins {
    kotlin("jvm") version "1.9.23"
}

group = "com.umpteenthdev"
version = "0.1"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}