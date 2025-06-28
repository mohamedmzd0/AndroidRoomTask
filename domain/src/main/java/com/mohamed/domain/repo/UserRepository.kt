package com.mohamed.domain.repo

import com.mohamed.domain.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun addUser(userEntity: UserEntity)
    suspend fun deleteUser(id: Int)
    suspend fun getAllUsers(): Flow<List<UserEntity>>
    suspend fun clearUsers()
}