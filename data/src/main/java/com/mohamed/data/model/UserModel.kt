package com.mohamed.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserModel(
    @PrimaryKey(autoGenerate = true) val id: Int?=null,
    val name: String,
    val age: Int,
    val title: String,
    val gender: String,
)