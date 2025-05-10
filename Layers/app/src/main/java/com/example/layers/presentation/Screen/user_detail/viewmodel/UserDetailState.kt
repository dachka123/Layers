package com.example.layers.presentation.Screen.user_detail.viewmodel

import com.example.layers.domain.model.UserDetailDomain

data class UserDetailState (
    val isLoading: Boolean = false,
    val user: UserDetailDomain? = null,
    var error: String = ""
)