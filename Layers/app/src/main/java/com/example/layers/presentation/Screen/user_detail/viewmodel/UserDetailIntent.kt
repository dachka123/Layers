package com.example.layers.presentation.Screen.user_detail.viewmodel

sealed class UserDetailIntent {

    data class FetchUser(val userLogin: String) : UserDetailIntent()
}