package com.example.layers.domain.use_case.getUsers

import com.example.layers.common.Resource
import com.example.layers.domain.model.User
import com.example.layers.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<Resource<List<User>>> = flow {
        emit(Resource.Loading())
        try {
            val users = repository.getUsers()
            emit(Resource.Success(users))
        }catch (e: Exception){
            emit(Resource.Error(e.message ?: "Unexpected error occurred"))
        }
    }
}