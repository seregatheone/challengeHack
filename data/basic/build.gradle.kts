plugins {
    id("com.android.library")
    kotlin("android")
}
android {
    namespace = ChallengeHackClient.namespace("data.basic")
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

    api(project(":domain:basic"))
    api(project(":common:domain"))
}
