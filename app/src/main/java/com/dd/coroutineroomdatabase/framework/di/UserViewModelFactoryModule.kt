package com.dd.coroutineroomdatabase.framework.di

import com.dd.coroutineroomdatabase.presentation.UserViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider


fun injectionActivityModule( ) = Kodein.Module(name = "ActivityModule") {

    bind<UserViewModelFactory>() with provider {
        UserViewModelFactory(
            instance()
        )
    }

}



//class UserViewModelFactoryModule(val kodein: Kodein) {
//
//    companion object {
//        val module = Kodein.Module {
//            bind<UserViewModelFactory>() with provider { UserViewModelFactory(instance()) }
//        }
//    }
//}


