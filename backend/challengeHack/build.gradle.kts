plugins {
    id("com.android.library")
    kotlin("android")
}
@Suppress("UnstableApiUsage")
android {
    namespace = ChallengeHackClient.namespace("backend.challengeHack")
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
    implementation(project(":backend:utils"))
}