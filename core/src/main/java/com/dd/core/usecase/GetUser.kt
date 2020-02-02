package com.dd.core.usecase

import com.dd.core.data.UserRepository
import com.dd.core.domain.User

class GetUser(private val repository: UserRepository) {
    suspend operator fun invoke(id: Long) = repository.getUser(id)
}

