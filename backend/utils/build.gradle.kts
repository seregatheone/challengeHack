plugins {
    id("com.android.library")
    kotlin("android")
}
@Suppress("UnstableApiUsage")
android {
    namespace = ChallengeHackClient.namespace("backend.utils")
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
    implementation(Dependencies.Network.Gson.lib)
    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.Coroutines.lib)
}