package com.dd.core.data

import com.dd.core.domain.User


class UserRepository(private val dataSource: UserDataSource ) {

    suspend fun insertUser(user: User) = dataSource.insert(user)
    suspend fun clearAllUsers() = dataSource.clearAll()
    suspend fun getUser(id: Long) = dataSource.get(id)
    suspend fun getAllUser() = dataSource.getAllUser()


//    val users = dao.getAllUsers()
//
//    suspend fun insert(user: UserEntity) {
//        dao.insert(user)
//    }
//
//    suspend fun clearAll() {
//        dao.deleteAll()
//    }


}