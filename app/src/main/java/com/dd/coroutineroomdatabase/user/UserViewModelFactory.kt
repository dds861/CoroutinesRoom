package com.dd.coroutineroomdatabase.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dd.coroutineroomdatabase.database.UserRepository

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
