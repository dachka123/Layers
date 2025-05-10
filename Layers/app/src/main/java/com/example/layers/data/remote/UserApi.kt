package com.example.layers.data.remote

import com.example.layers.data.remote.dto.UserDetailDto
import com.example.layers.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    companion object{
        const val USERS_ENDPOINT = "/users.json"
        const val USER_DETAIL_ENDPOINT = "/user/{userLogin}.json"
    }

    @GET(USERS_ENDPOINT)
    suspend fun getUsers(): List<UserDto>

    @GET(USER_DETAIL_ENDPOINT)
    suspend fun getUserByName(@Path("userLogin") userLogin: String): UserDetailDto


}