// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    TODO 2 - Implement Plugins and Dependencies
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.hiltAndroid) apply false
    alias(libs.plugins.org.jetbrains.kotlin.kapt) apply false
}