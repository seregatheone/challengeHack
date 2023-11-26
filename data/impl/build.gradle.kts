plugins {
    id("com.android.library")
    kotlin("android")
}
android {
    namespace = ChallengeHackClient.namespace("data.impl")
    compileSdk = ChallengeHackClient.DefaultConfig.compileSdk
    defaultConfig {
        minSdk = ChallengeHackClient.DefaultConfig.minSdk
        targetSdk = ChallengeHackClient.DefaultConfig.targetSdk
    }
    compileOptions {
        sourceCompatibility = ChallengeHackClient.DefaultConfig.jVersion
        targetCompatibility = ChallengeHackClient.DefaultConfig.jVersion
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(Dependencies.Core.Ktx.lib)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Network.Retrofit.lib)
    implementation(Dependencies.Network.Gson.lib)
    implementation(Dependencies.Network.Logging.lib)
    implementation(Dependencies.Coroutines.lib)

    implementation(Dependencies.RxJava2.lib)
    implementation(Dependencies.RxJava2.androidLib)

    implementation(Dependencies.Websocket.stompLib)

    implementation(Dependencies.Paging.pagingLib)
    implementation(Dependencies.Paging.pagingLib)

    implementation(Dependencies.WebRtc.lib)
    implementation(Dependencies.WebRtc.logger)

    api(project(":data:basic"))

    implementation(project(":backend:challengeHack"))
    implementation(project(":backend:utils"))
    implementation(project(":backend:websockets"))
    implementation(project(":backend:webRtc"))
}
