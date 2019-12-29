package com.dd.coroutineroomdatabase.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dd.coroutineroomdatabase.database.User
import com.dd.coroutineroomdatabase.database.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    val users = repository.users

    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }

    fun clearAll() {
        viewModelScope.launch {
            repository.clearAll()
        }
    }
}