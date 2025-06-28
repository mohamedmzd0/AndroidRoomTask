package com.mohamed.data.di

import android.content.Context
import androidx.room.Room
import com.mohamed.data.local.AppDatabase
import com.mohamed.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java, "users_db"
        ).addMigrations().build()
    }

    @Provides
    fun provideDao(db: AppDatabase): UserDao = db.userDao()
}