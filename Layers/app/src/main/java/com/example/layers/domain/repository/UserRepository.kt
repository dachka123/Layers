package com.example.layers.domain.repository

import com.example.layers.common.Resource
import com.example.layers.domain.model.UserDomain
import com.example.layers.domain.model.UserDetailDomain
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun getUsers(): Flow<Resource<List<UserDomain>>>

    suspend fun getUserByName(userLogin: String): Flow<Resource<UserDetailDomain>>
}