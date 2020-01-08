package com.dd.coroutineroomdatabase.inject

import com.dd.coroutineroomdatabase.database.UserRepository
import com.dd.coroutineroomdatabase.user.MainActivity
import com.dd.coroutineroomdatabase.user.UserViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton


fun injectionActivityModule( ) = Kodein.Module(name = "ActivityModule") {

    bind<UserViewModelFactory>() with provider { UserViewModelFactory(instance()) }

}



//class UserViewModelFactoryModule(val kodein: Kodein) {
//
//    companion object {
//        val module = Kodein.Module {
//            bind<UserViewModelFactory>() with provider { UserViewModelFactory(instance()) }
//        }
//    }
//}


