plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "de.jarvis.assistant"
    compileSdk = 35

    defaultConfig {
        applicationId = "de.jarvis.assistant"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
}
