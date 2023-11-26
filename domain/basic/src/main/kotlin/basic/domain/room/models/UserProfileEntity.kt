package basic.domain.room.models

data class UserProfileEntity(
    val userId: Long,
    val username: String,
    val profilePictureUrl: String,
)
