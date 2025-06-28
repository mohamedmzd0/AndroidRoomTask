package com.mohamed.data.di

import com.mohamed.domain.usecase.AddUserUseCase
import com.mohamed.domain.usecase.AddUserUseCaseImpl
import com.mohamed.domain.usecase.GetUsersUseCase
import com.mohamed.domain.usecase.GetUsersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface UseCaseProvider {

    @Binds
    @Singleton
    fun provideAddUserUseCase(
        usecase: AddUserUseCaseImpl
    ): AddUserUseCase

    @Binds
    @Singleton
    fun GetUsersUseCase(
        usecase: GetUsersUseCaseImpl
    ): GetUsersUseCase

}
