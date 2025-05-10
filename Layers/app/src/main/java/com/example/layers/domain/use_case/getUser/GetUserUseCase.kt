package com.example.layers.domain.use_case.getUser

import com.example.layers.common.Resource
import com.example.layers.domain.model.UserDetailDomain
import com.example.layers.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    /*operator fun invoke(userLogin: String): Flow<Resource<UserDetailDomain>> = flow {

        emit(Resource.Loading())
        try {
            val user = repository.getUserByName(userLogin)
            emit(Resource.Success(user))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unexpected error occurred"))
        }
    }*/
    suspend operator fun invoke(userLogin: String): Flow<Resource<UserDetailDomain>> {
        return repository.getUserByName(userLogin)
    }
}