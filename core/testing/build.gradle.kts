plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.maxim.testing"
    compileSdk = 36
    defaultConfig { minSdk = 29 }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // Testing
    implementation(libs.junit)
    implementation(libs.kotlinx.coroutines.test)

    // Modules
    implementation(project(":core:model"))
}