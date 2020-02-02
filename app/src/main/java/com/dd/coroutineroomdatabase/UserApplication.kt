package com.dd.coroutineroomdatabase

import android.app.Application
import android.content.Context
import com.dd.coroutineroomdatabase.database.UserDAO
import com.dd.coroutineroomdatabase.database.UserDatabase
import com.dd.coroutineroomdatabase.database.UserRepository
import com.dd.coroutineroomdatabase.user.UserViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class UserApplication : Application(), KodeinAware {


    override val kodein = Kodein.lazy {
//        import(UserViewModelFactoryModule.module)

        bind<Context>() with singleton { this@UserApplication.applicationContext }
        bind<UserDatabase>() with singleton { UserDatabase.getInstance(instance()) }
        bind<UserDAO>() with singleton { instance<UserDatabase>().userDAO }
        bind<UserRepository>() with singleton { UserRepository(instance()) }
//        bind<UserViewModelFactory>() with provider { UserViewModelFactory(instance()) }
        bind<UserViewModelFactory>() with provider { UserViewModelFactory(instance()) }
    }


}


