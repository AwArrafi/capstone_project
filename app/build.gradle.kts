plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.gms.google-services")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.capstoneproject"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.capstoneproject"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        mlModelBinding = true
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //Material Design
    implementation (libs.material)
    implementation (libs.material.v140)

    //Navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    //Camera X
    implementation ("androidx.camera:camera-core:1.4.0")
    implementation(libs.androidx.camera.camera2)
    implementation(libs.camera.lifecycle)
    implementation(libs.camera.view)

    // Retrofit untuk API calls
    implementation (libs.retrofit)

    // Gson converter untuk Retrofit
    implementation (libs.converter.gson)

    // Kotlin Coroutines untuk asynchronous programming
    implementation (libs.kotlinx.coroutines.android)

    // Lifecycle for coroutine scope in Activity/Fragment
    implementation (libs.androidx.lifecycle.runtime.ktx)
    implementation (libs.logging.interceptor)

    implementation (libs.androidx.datastore.preferences)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.lifecycle.viewmodel.savedstate)

    implementation (libs.hilt.android)
    implementation (libs.androidx.hilt.lifecycle.viewmodel)

    implementation (libs.glide)
    implementation(libs.tensorflow.lite.support)
    implementation(libs.tensorflow.lite.metadata)
    implementation(libs.tensorflow.lite.gpu)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Model Ml
    implementation ("org.tensorflow:tensorflow-lite:2.13.0")
    implementation ("org.tensorflow:tensorflow-lite-task-vision:0.4.4")
    implementation ("org.tensorflow:tensorflow-lite-support:0.4.4")

    implementation(platform("com.google.firebase:firebase-bom:33.7.0"))
    implementation("com.google.firebase:firebase-ml-modeldownloader:25.0.1")
    implementation("com.google.firebase:firebase-analytics")
}