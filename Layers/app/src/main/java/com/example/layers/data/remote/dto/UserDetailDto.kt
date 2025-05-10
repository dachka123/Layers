package com.example.layers.data.remote.dto

import com.example.layers.domain.model.UserDetailDomain

data class UserDetailDto(
    val followers: Int,
    val following: Int,
    val login: String,
)

fun UserDetailDto.toUserDetailDomain(): UserDetailDomain{
    return UserDetailDomain(
        userLogin = login,
        followers = followers,
        following = following
    )
}
