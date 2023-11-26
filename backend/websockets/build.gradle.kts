plugins {
    id("com.android.library")
    kotlin("android")
}
@Suppress("UnstableApiUsage")
android {
    namespace = ChallengeHackClient.namespace("backend.websockets")
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
    implementation(Dependencies.Websocket.stompLib)
    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.Coroutines.lib)

    implementation(project(":domain:basic"))
}