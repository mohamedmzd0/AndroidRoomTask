package com.mohamed.myapplication.ui.add_user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.domain.entity.UserEntity
import com.mohamed.domain.entity.UserGender
import com.mohamed.domain.usecase.AddUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(
    private val addUserUseCase: AddUserUseCase
) : ViewModel() {

    fun addUser(name: String, age: Int, title: String, gender: UserGender) {
        viewModelScope.launch {
            val user = UserEntity(
                id = 0,
                name = name,
                age = age,
                title = title,
                gender = gender
            )
            addUserUseCase(user)
        }
    }
}
