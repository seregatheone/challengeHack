import org.gradle.api.JavaVersion

object ChallengeHackClient {
    const val appName = "ChallengeHack"
    const val dimension = "ChallengeHack"

    object DefaultConfig {
        const val id = "pat.project.challengehack"
        const val minSdk = 26
        const val targetSdk = 33
        const val versionCode = 1
        const val releseNumber = 1
        const val compileSdk = 33
        const val versionName = "0.$releseNumber.$versionCode"
        const val kotlinCompilerExtensionVersion = "1.4.3"

        val challengeHackBackend = Field(
            type = "String",
            name = "CHALLENGE_HACK_BACKEND",
            value = "\"a\"",
        )
        val challengeHackWebsockets = Field(
            type = "String",
            name = "CHALLENGE_HACK_WEBSOCKETS",
            value = "\"a\"",
        )

        val jvmTarget = JavaVersion.VERSION_18.toString()
        val jVersion = JavaVersion.VERSION_18

    }

    fun namespace(currentPackage: String): String = "${DefaultConfig.id}.$currentPackage"
}

data class Field(
    val type : String,
    val name : String,
    val value : String,
)