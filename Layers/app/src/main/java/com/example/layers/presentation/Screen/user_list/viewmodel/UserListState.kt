package com.example.layers.presentation.Screen.user_list.viewmodel

import com.example.layers.domain.model.UserDomain

data class UserListState(
    val isLoading: Boolean = false,
    val userDomains: List<UserDomain> = emptyList(),
    var error: String = ""
)