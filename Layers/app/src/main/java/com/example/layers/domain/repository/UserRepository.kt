package com.example.layers.domain.repository

import com.example.layers.domain.model.User
import com.example.layers.domain.model.UserDetail

interface UserRepository {

    suspend fun getUsers(): List<User>

    suspend fun getUserByName(userLogin: String): UserDetail
}