package com.example.layers.data.remote.dto

import com.example.layers.domain.model.UserDomain
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("avatar_url") val avatarUrl: String,
    val id: Int,
    val login: String,
)

fun UserDto.toUserDomain(): UserDomain{
    return UserDomain(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
    )
}