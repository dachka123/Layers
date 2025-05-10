package com.example.layers.domain.use_case.getUsers

import com.example.layers.common.Resource
import com.example.layers.domain.model.UserDomain
import com.example.layers.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    /*operator fun invoke(): Flow<Resource<List<UserDomain>>> = flow {
        emit(Resource.Loading())
        try {
            val users = repository.getUsers()
            emit(Resource.Success(users))
        }catch (e: Exception){
            emit(Resource.Error(e.message ?: "Unexpected error occurred"))
        }
    }*/
    suspend operator fun invoke(): Flow<Resource<List<UserDomain>>> {
        return repository.getUsers()
    }
}