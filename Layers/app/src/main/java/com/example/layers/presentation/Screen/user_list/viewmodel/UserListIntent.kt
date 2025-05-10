package com.example.layers.presentation.Screen.user_list.viewmodel

sealed class UserListIntent {

    object LoadUsers : UserListIntent()
}