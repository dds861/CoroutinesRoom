package com.dd.coroutineroomdatabase.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dd.core.data.UserRepository
import com.dd.coroutineroomdatabase.presentation.main.UserViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.instanceOrNull

class UserViewModelFactory(private val injector: Kodein) : ViewModelProvider.Factory {
//    @Suppress("unchecked_cast")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
//            return UserViewModel(
//                repository
//            ) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return injector.instanceOrNull<ViewModel>(tag = modelClass.simpleName) as T?
            ?: modelClass.newInstance()
    }
}
