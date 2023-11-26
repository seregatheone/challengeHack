
plugins {
    id("com.android.library")
    kotlin("android")
}
android {
    namespace = ChallengeHackClient.namespace("domain.impl")
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
    implementation(Dependencies.Coroutines.lib)

    implementation(Dependencies.Paging.pagingLib)
    implementation(Dependencies.Paging.pagingLib)

    api(project(":domain:basic"))
    implementation(project(":data:basic"))
}
