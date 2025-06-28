package com.mohamed.data.mapper

import com.mohamed.data.model.UserModel
import com.mohamed.domain.entity.UserEntity
import com.mohamed.domain.entity.UserGender
import javax.inject.Inject

class UserMapper @Inject constructor() {
    fun invoke(list: List<UserModel>): List<UserEntity> {
        return list.map {
            UserEntity(
                id = it.id?:0,
                name = it.name,
                age = it.age,
                title = it.title,
                gender = UserGender.fromValue(it.gender.lowercase())
            )
        }
    }
}
