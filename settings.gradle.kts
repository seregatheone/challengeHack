pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "ChallengeHack"
include(
    ":app",

    ":domain:impl",
    ":domain:basic",

    ":data:impl",
    ":data:basic",

    ":backend:utils",
    ":backend:webRtc",
    ":backend:challengeHack",
    ":backend:websockets",

    ":core:ui",

    ":common:domain",
    ":utils",
)
 