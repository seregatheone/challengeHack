plugins {
    id("com.android.library")
    kotlin("android")
}
@Suppress("UnstableApiUsage")
android {
    namespace = ChallengeHackClient.namespace("core.ui")
    compileSdk = ChallengeHackClient.DefaultConfig.compileSdk
    defaultConfig {
        minSdk = ChallengeHackClient.DefaultConfig.minSdk
        targetSdk = ChallengeHackClient.DefaultConfig.targetSdk
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ChallengeHackClient.DefaultConfig.kotlinCompilerExtensionVersion
    }

    compileOptions {
        sourceCompatibility = ChallengeHackClient.DefaultConfig.jVersion
        targetCompatibility = ChallengeHackClient.DefaultConfig.jVersion
    }
}

dependencies {
    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.Matherial.material)
    implementation(Dependencies.Matherial.material3)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.uiToolingPreview)
    implementation(Dependencies.Coil.libSvg)
    implementation(Dependencies.Coil.lib)
    implementation(Dependencies.Compose.matherialIcons)
    debugImplementation(Dependencies.Compose.uiTooling)

    implementation (Dependencies.Accompanist.systemUiController)

    implementation(project(":domain:basic"))
}