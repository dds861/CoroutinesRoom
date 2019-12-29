package com.dd.coroutineroomdatabase.database

class UserRepository(private val dao: UserDAO) {

    val users = dao.getAllUsers()

    suspend fun insert(user: User) {
        dao.insert(user)
    }

    suspend fun clearAll() {
        dao.deleteAll()
    }
}