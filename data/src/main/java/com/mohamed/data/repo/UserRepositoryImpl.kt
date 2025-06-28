package com.mohamed.data.repo

import com.mohamed.data.local.UserDao
import com.mohamed.data.mapper.UserMapper
import com.mohamed.data.model.UserModel
import com.mohamed.domain.entity.UserEntity
import com.mohamed.domain.entity.UserGender
import com.mohamed.domain.repo.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val mapper: UserMapper
) : UserRepository {


    fun toModel(entity: UserEntity): UserModel {
        return UserModel(
            name = entity.name,
            age = entity.age,
            title = entity.title,
            gender = when (entity.gender) {
                is UserGender.Male -> "male"
                is UserGender.Female -> "female"
            }
        )
    }

    override suspend fun addUser(userEntity: UserEntity) {
        userDao.insertUser(toModel(userEntity))
    }

    override suspend fun deleteUser(id: Int) {
        userDao.deleteUser(id)
    }

    override suspend fun getAllUsers(): Flow<List<UserEntity>> {
        return userDao.getUsers().map { userModels ->
            mapper.invoke(userModels)
        }
    }

    override suspend fun clearUsers() {
        userDao.clearUsers()
    }
}
