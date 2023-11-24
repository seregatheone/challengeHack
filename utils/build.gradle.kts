plugins {
    id("com.android.library")
    kotlin("android")
}
android {
    namespace = ChallengeHackClient.namespace("utils")
    compileSdk = ChallengeHackClient.DefaultConfig.compileSdk
    defaultConfig {
        minSdk = ChallengeHackClient.DefaultConfig.minSdk
        targetSdk = ChallengeHackClient.DefaultConfig.targetSdk
    }
    compileOptions {
        sourceCompatibility = ChallengeHackClient.DefaultConfig.jVersion
        targetCompatibility = ChallengeHackClient.DefaultConfig.jVersion
    }
}

dependencies {
    implementation(Dependencies.Core.Ktx.lib)
}
