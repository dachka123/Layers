package com.example.layers.data.repository

import com.example.layers.data.remote.UserApi
import com.example.layers.data.remote.dto.toUser
import com.example.layers.data.remote.dto.toUserDetail
import com.example.layers.domain.model.User
import com.example.layers.domain.model.UserDetail
import com.example.layers.domain.repository.UserRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
): UserRepository {


    override suspend fun getUsers(): List<User> {

        return try{
            api.getUsers().map { it.toUser() }
        }catch (e: HttpException){
            throw Exception(e.localizedMessage ?: "An unexpected error occurred")
        }catch (e: IOException){
            throw Exception("Couldn't reach server. Check your internet connection.")
        }
    }

    override suspend fun getUserByName(userLogin: String): UserDetail {
        return try{
            api.getUserByName(userLogin).toUserDetail()
        }catch (e: HttpException){
            throw Exception(e.localizedMessage ?: "An unexpected error occurred")
        }catch (e: IOException){
            throw Exception("Couldn't reach server. Check your internet connection.")
        }
    }


}