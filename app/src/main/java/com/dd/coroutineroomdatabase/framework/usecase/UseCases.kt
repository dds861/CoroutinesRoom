package com.dd.coroutineroomdatabase.framework.usecase

import com.dd.core.usecase.*


data class UseCases(
    val clearAllUsersUseCase: ClearAllUsers,
    val insertUserUseCase: InsertUser,
    val getUser: GetUser
)