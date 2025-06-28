package com.mohamed.data.di

import com.mohamed.data.repo.UserRepositoryImpl
import com.mohamed.domain.repo.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoProvider {

    @Binds
    @Singleton
    fun provideRepo(
        repo: UserRepositoryImpl
    ): UserRepository

}
