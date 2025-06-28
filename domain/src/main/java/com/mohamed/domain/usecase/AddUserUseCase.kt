package com.mohamed.domain.usecase

import com.mohamed.domain.entity.UserEntity
import com.mohamed.domain.repo.UserRepository
import javax.inject.Inject

interface AddUserUseCase {
    suspend operator fun invoke(userEntity: UserEntity)
}

class AddUserUseCaseImpl @Inject constructor(private val userRepository: UserRepository) :
    AddUserUseCase {
    override suspend operator fun invoke(userEntity: UserEntity) {
        userRepository.addUser(userEntity)
    }

}