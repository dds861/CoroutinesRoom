package com.dd.coroutineroomdatabase.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dd.core.domain.User
import com.dd.coroutineroomdatabase.framework.db.entity.UserEntity
import com.dd.coroutineroomdatabase.framework.di.UserApplication
import com.dd.coroutineroomdatabase.framework.usecase.UseCases
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class UserViewModel(application: UserApplication) : ViewModel(), KodeinAware {

    override val kodein: Kodein = application.kodein

    private val useCases: UseCases by instance()


    val saved = MutableLiveData<Boolean>()
    val currentUser = MutableLiveData<User?>()
    val users = MutableLiveData<List<User>>()

    fun insert(user: User) = viewModelScope.launch {
        useCases.insertUserUseCase(user)
        saved.postValue(true)
    }

    fun clearAll() {
        viewModelScope.launch {
            useCases.clearAllUsersUseCase()
            saved.postValue(true)
        }
    }

    fun getNote(id: Long) {
        viewModelScope.launch {
            val user = useCases.getUser(id)
            currentUser.postValue(user)
        }
    }

    fun getAllNote(id: Long) {
        viewModelScope.launch {
            val userList = useCases.clearAllUsersUseCase()
            users.postValue(userList)
        }
    }

}