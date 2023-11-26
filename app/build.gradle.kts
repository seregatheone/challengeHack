plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
}

android {
    namespace = ChallengeHackClient.DefaultConfig.id
    compileSdk = ChallengeHackClient.DefaultConfig.compileSdk

    defaultConfig {

        applicationId = ChallengeHackClient.DefaultConfig.id
        minSdk = ChallengeHackClient.DefaultConfig.minSdk
        targetSdk = ChallengeHackClient.DefaultConfig.targetSdk
        versionCode = ChallengeHackClient.DefaultConfig.versionCode
        versionName = ChallengeHackClient.DefaultConfig.versionName

        with(ChallengeHackClient.DefaultConfig.challengeHackBackend) {
            buildConfigField(
                type = type,
                name = name,
                value = value
            )
        }
        with(ChallengeHackClient.DefaultConfig.challengeHackWebsockets) {
            buildConfigField(
                type = type,
                name = name,
                value = value
            )
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = ChallengeHackClient.DefaultConfig.jVersion
        targetCompatibility = ChallengeHackClient.DefaultConfig.jVersion
    }
    kotlinOptions {
        jvmTarget = ChallengeHackClient.DefaultConfig.jvmTarget
        freeCompilerArgs += listOf("-opt-in=androidx.compose.material3.ExperimentalMaterial3Api")
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion =
            ChallengeHackClient.DefaultConfig.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {


    implementation(Dependencies.Core.Ktx.lib)

    implementation(Dependencies.Core.Lifecycle.libRuntime)
    implementation(Dependencies.Core.Lifecycle.libCommon)
    implementation(Dependencies.Core.Lifecycle.libViewModels)
    implementation(Dependencies.Core.Lifecycle.libCompose)

    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiToolingPreview)
    debugImplementation(Dependencies.Compose.uiTooling)
    implementation(Dependencies.Compose.navLib)

    implementation(Dependencies.Splashscreen.lib)

    implementation(Dependencies.Matherial.material)
    implementation(Dependencies.Matherial.material3)

    implementation(Dependencies.Coil.lib)
    implementation(Dependencies.Coil.libSvg)

    testImplementation(Dependencies.Testing.JUnit.junit)
    androidTestImplementation(Dependencies.Testing.JUnit.junitExt)

    androidTestImplementation(Dependencies.Testing.Espresso.lib)

    implementation(Dependencies.DaggerHilt.hilt)
    kapt(Dependencies.DaggerHilt.daggerHiltCompiler)
    implementation(Dependencies.DaggerHilt.hiltCompose)

    implementation(Dependencies.Coroutines.lib)

    implementation(Dependencies.Paging.pagingCompose)
    implementation(Dependencies.Paging.pagingLib)

    implementation(Dependencies.Websocket.stompLib)
    implementation(Dependencies.RxJava2.lib)
    implementation(Dependencies.RxJava2.androidLib)

    implementation(Dependencies.WebRtc.lib)
    implementation(Dependencies.WebRtc.logger)

    implementation ("com.google.zxing:core:3.4.0")
    //module
    implementation(project(":core:ui"))

    implementation(project(":backend:challengeHack"))
    implementation(project(":backend:utils"))
    implementation(project(":backend:websockets"))
    implementation(project(":backend:webRtc"))

    implementation(project(":utils"))

    implementation(project(":domain:impl"))
    implementation(project(":data:impl"))

    implementation(Dependencies.Compose.matherialIcons)
}