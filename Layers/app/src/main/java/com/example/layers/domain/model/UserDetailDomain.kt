package com.example.layers.domain.model

data class UserDetailDomain(
    val userLogin: String,
    val followers: Int,
    val following: Int
)
