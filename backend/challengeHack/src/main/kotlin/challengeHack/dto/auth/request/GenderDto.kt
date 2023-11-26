package challengeHack.dto.auth.request

import com.google.gson.annotations.SerializedName

enum class GenderDto{
    @SerializedName("male")
    MALE,
    @SerializedName("female")
    FEMALE
}