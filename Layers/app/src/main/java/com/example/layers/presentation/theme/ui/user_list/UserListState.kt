package com.example.layers.presentation.theme.ui.user_list

import com.example.layers.domain.model.User

data class UserListState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    var error: String = ""
)