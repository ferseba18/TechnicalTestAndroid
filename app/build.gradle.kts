plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.technicaltestandroid"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.technicaltestandroid"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    dependencies {
        // OAuth client library
        implementation ("com.squareup.okhttp3:okhttp:4.11.1")
        implementation ("com.squareup.okhttp3:logging-interceptor:4.9.3")
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

        // JSON parsing library
        implementation ("com.google.code.gson:gson:2.9.0")

        // RxJava for reactive programming
        implementation ("io.reactivex.rxjava2:rxjava:2.2.21")
        implementation ("io.reactivex.rxjava2:rxandroid:2.1.1")
        //Jetpack Compose
        implementation ("androidx.compose.ui:ui:1.5.4")
        implementation ("androidx.compose.material:material:1.5.4")
        implementation ("androidx.compose.runtime:runtime:1.5.4")
        implementation("androidx.compose.ui:ui-tooling-preview-android:1.5.4")
        implementation("androidx.activity:activity-ktx:1.8.0")
        implementation ("androidx.compose.material3:material3:1.2.0-alpha01")
        implementation("androidx.test:monitor:1.6.1")
        implementation("androidx.test.ext:junit-ktx:1.1.5")
        implementation("androidx.appcompat:appcompat:1.6.1")
        testImplementation("junit:junit:4.13.2")
        implementation ("androidx.appcompat:appcompat:1.6.1")
        implementation ("androidx.activity:activity-ktx:1.8.0")
        implementation ("androidx.activity:activity-compose:1.3.0")
        implementation ("androidx.compose.ui:ui:1.0.0")
        implementation ("androidx.compose.material:material:1.0.0")
        // Securely store tokens
        implementation ("androidx.security:security-crypto:1.1.0-alpha03")
    }
}