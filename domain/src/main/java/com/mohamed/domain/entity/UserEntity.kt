package com.mohamed.domain.entity

data class UserEntity(
    val id: Int, val name: String, val age: Int, val title: String, val gender: UserGender
)

sealed class UserGender(value: String) {
    data object Male : UserGender("male")
    data object Female : UserGender("female")

    companion object {
        fun fromValue(value: String): UserGender {
            return when (value) {
                "male" -> Male
                "female" -> Female
                else -> throw IllegalStateException("UserType not defined")
            }
        }

        fun toValue(userGender: UserGender): String {
            return when (userGender) {
                is Male -> "male"
                is Female -> "female"
            }
        }
    }
}