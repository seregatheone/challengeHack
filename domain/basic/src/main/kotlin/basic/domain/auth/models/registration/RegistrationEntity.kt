package basic.domain.auth.models.registration

data class RegistrationEntity(
    val username : String,
    val password : String,
    val email : String,
    val gender : GenderEntityRegistration
)