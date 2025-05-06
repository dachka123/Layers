package com.example.layers.domain.repository

import com.example.layers.domain.model.User
import com.example.layers.domain.model.UserDetail

interface UserRepository {
    // FIXME: რეპოზიტორი უნდა აბრუნებდეს ფლოუს და რესურსსაც
    suspend fun getUsers(): List<User>
    suspend fun getUserByName(userLogin: String): UserDetail
}