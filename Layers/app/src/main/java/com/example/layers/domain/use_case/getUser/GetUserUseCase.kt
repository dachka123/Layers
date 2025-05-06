package com.example.layers.domain.use_case.getUser

import com.example.layers.common.Resource
import com.example.layers.domain.model.UserDetail
import com.example.layers.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

// FIXME: აქ არ უნდა ხდებოდეს ფლოუდ გარდაქმნა
//  აქ რასაც აკეღებ აზრობრივად რეპოზიტორის დანიშნულებაა
//  მეორე უსქეისშიც გაითვალისწინე და ცალცალკე ფექიჯების გაკეთება არაა საჭირო
//  ასევე
class GetUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(userLogin: String): Flow<Resource<UserDetail>> = flow {

        emit(Resource.Loading())
        try {
            val user = repository.getUserByName(userLogin)
            emit(Resource.Success(user))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unexpected error occurred"))
        }
    }
}