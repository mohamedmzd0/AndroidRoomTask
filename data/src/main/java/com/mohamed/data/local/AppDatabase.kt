package com.mohamed.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohamed.data.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}