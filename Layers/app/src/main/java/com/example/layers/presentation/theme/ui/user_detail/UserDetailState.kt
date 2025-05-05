package com.example.layers.presentation.theme.ui.user_detail

import com.example.layers.domain.model.UserDetail

data class UserDetailState (
    val isLoading: Boolean = false,
    val user: UserDetail? = null,
    var error: String = ""
)