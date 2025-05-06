package com.example.layers.presentation.theme

// FIXME: ესეც მოსაშორებელია ნავიგაცია ახლებური მიდგომით უნდა გადააკეთო რაც დაგიწერე 
sealed class Screen(val route:String) {

    object UserListScreen: Screen("user_list_screen")
    object UserDetailScreen: Screen("user_detail_screen")

}