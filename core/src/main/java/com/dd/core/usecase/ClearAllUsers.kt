package com.dd.core.usecase

import com.dd.core.data.UserRepository

class ClearAllUsers(private val repository: UserRepository) {
    suspend operator fun invoke() = repository.clearAllUsers()
}

