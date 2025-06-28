package com.mohamed.myapplication.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.domain.entity.UserEntity
import com.mohamed.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {
    private val _users = MutableStateFlow<List<UserEntity>>(emptyList())
    val users = _users.asStateFlow()

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            getUsersUseCase().collectLatest {
                _users.emit(it)
            }
        }
    }

}
