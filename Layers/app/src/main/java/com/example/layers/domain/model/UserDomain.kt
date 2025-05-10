package com.example.layers.domain.model

import com.google.gson.annotations.SerializedName

data class UserDomain(
    val id: Int,
    val login: String,
    @SerializedName("avatar_url") val avatarUrl: String,
)

