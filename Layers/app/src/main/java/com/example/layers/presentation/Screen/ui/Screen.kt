package com.example.layers.presentation.Screen.ui

import kotlinx.serialization.Serializable


@Serializable
object StartScreen

@Serializable
data class UserDetailRoute(val userLogin: String)

/*
sealed class Screen(val route:String) {

    object UserListScreen: Screen("user_list_screen")
    object UserDetailScreen: Screen("user_detail_screen")

}*/
