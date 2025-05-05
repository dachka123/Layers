package com.example.layers.data.remote

import com.example.layers.data.remote.dto.UserDetailDto
import com.example.layers.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/users.json")
    suspend fun getUsers(): List<UserDto>

    @GET("/user/{userLogin}.json")
    suspend fun getUserByName(@Path("userLogin") userLogin: String): UserDetailDto
}