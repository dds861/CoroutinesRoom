package com.dd.coroutineroomdatabase.framework.di

import android.app.Application
import android.content.Context
import com.dd.coroutineroomdatabase.framework.db.dao.UserDAO
import com.dd.coroutineroomdatabase.framework.db.DatabaseService
import com.dd.coroutineroomdatabase.presentation.UserViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class UserApplication : Application(), KodeinAware {


    override val kodein = Kodein.lazy {
//                import(UserViewModelFactoryModule.module)

        bind<Context>() with singleton { this@UserApplication.applicationContext }
        bind<DatabaseService>() with singleton { DatabaseService.getInstance(instance()) }
        bind<UserDAO>() with singleton { instance<DatabaseService>().userDAO }


//        bind<UserRepository>() with singleton { UserRepository(instance()) }

//        bind<UserViewModelFactory>() with provider { UserViewModelFactory(instance()) }
        bind<UserViewModelFactory>() with provider { UserViewModelFactory(instance()) }
    }


}


