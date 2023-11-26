package basic.domain.auth.models.registration

enum class GenderEntityRegistration(
    val genderName: String
) {
    MALE("Male"),
    FEMALE("Female");


}
 fun String.getGenderEntityByName(): GenderEntityRegistration {
    return when(this){
        GenderEntityRegistration.MALE.genderName -> GenderEntityRegistration.MALE
        GenderEntityRegistration.FEMALE.genderName -> GenderEntityRegistration.FEMALE
        else -> GenderEntityRegistration.MALE
    }
}