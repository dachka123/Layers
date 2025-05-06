package com.example.layers.data.remote.dto

import com.example.layers.domain.model.User

// FIXME: აქაც გაასწორე ქვედა ტირეებით არ უნდა იყოს
//  სახელები და უნდა იყოს CamelCase

data class UserDto(
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String,
    val user_view_type: String
)

// FIXME: მაპერის სახელი აქაც გაასწორე
fun UserDto.toUser(): User{
    return User(
        id = id,
        login = login,
        avatar_url = avatar_url
    )
}