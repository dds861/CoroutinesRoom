package com.dd.coroutineroomdatabase.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dd.coroutineroomdatabase.constants.ConstantsApp
import com.dd.coroutineroomdatabase.framework.db.dao.UserDAO
import com.dd.coroutineroomdatabase.framework.db.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class DatabaseService : RoomDatabase() {
    abstract val userDAO: UserDAO

    companion object {
        @Volatile
        private var INSTANCE: DatabaseService? = null

        fun getInstance(context: Context): DatabaseService {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseService::class.java,
                        ConstantsApp.USER_DATA_DATABASE
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return instance
            }
        }
    }
}