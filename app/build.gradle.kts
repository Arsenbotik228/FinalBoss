plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.navigation.args)
    id("com.google.gms.google-services")

}

android {
    namespace = "com.myself223.graduationtestassignment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.myself223.graduationtestassignment"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        buildConfigField("String","BASE_URL","\"https://rickandmortyapi.com/api/\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures{
        viewBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(platform("com.google.firebase:firebase-bom:33.1.2")) // BOM version
    implementation("com.google.firebase:firebase-auth-ktx") // Firebase Authentication with Kotlin extensions
    implementation("com.google.android.gms:play-services-auth:21.2.0") // Google Sign-In services
    implementation("com.google.android.gms:play-services-location:21.3.0") // Play services location for location-based features
    implementation("com.google.firebase:firebase-firestore-ktx") // Firestore with Kotlin extensions
    implementation("com.google.firebase:firebase-storage-ktx") // Firebase Storage with Kotlin extensions
    implementation("com.google.firebase:firebase-analytics-ktx") // Firebase Analytics with Kotlin extensions
    implementation ("com.google.firebase:firebase-analytics")
    implementation ("com.google.firebase:firebase-auth")
    implementation ("com.google.firebase:firebase-bom:31.1.1")
    implementation("com.google.firebase:firebase-messaging:23.0.6")

    //Ui
    implementation(libs.bundles.ui.component)
    //Test
    implementation(libs.bundles.test.component)
    //Retrofit
    implementation(libs.bundles.network.component)
    //Koin
    implementation(libs.bundles.koin.component)
    //OkHttp
    implementation(platform(libs.okhttp.bom))
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    //Nav Component
    implementation(libs.bundles.navigaion.component)
    implementation(project(":features:main"))



}