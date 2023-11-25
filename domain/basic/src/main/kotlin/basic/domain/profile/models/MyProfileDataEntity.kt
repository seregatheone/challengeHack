package basic.domain.profile.models

data class MyProfileDataEntity (
     val userId : Long,
     val username : String,
     val profilePictureUrl : String,
     val email : String,
)