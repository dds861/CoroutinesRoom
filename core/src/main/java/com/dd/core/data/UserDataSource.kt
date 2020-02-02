package com.dd.core.data

import com.dd.core.domain.User

interface UserDataSource{
    suspend fun insert(user: User): User
    suspend fun clearAll():List<User>
    suspend fun get(id: Long): User?
    suspend fun getAllUser(): List<User>
}

