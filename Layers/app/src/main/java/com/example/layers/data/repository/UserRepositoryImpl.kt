package com.example.layers.data.repository

import com.example.layers.common.Resource
import com.example.layers.data.remote.UserApi
import com.example.layers.data.remote.dto.toUserDomain
import com.example.layers.data.remote.dto.toUserDetailDomain
import com.example.layers.domain.model.UserDomain
import com.example.layers.domain.model.UserDetailDomain
import com.example.layers.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
    private val handler: NetworkHandler
): UserRepository {

    override suspend fun getUsers(): Flow<Resource<List<UserDomain>>>{
        return handler.safeApiCall {
            api.getUsers().map { it.toUserDomain() }
        }
    }

    override suspend fun getUserByName(userLogin: String): Flow<Resource<UserDetailDomain>>{
        return handler.safeApiCall {
            api.getUserByName(userLogin).toUserDetailDomain()
        }
    }
}