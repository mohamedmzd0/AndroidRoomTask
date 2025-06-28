package com.mohamed.domain.usecase

import com.mohamed.domain.entity.UserEntity
import com.mohamed.domain.repo.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetUsersUseCase {
    suspend operator fun invoke(): Flow<List<UserEntity>>
}

class GetUsersUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    GetUsersUseCase {
    override suspend operator fun invoke() =
        userRepository.getAllUsers()

}