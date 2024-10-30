buildscript {
    repositories {
        // other repositories...
        mavenCentral()
    }
    dependencies {
        classpath (libs.hilt.android.gradle.plugin)
        classpath (libs.kotlin.serialization)
        classpath (libs.hilt.android.gradle.plugin)
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id("com.google.devtools.ksp") version "2.0.20-1.0.25" apply false
}