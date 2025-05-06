package com.example.layers.presentation.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.layers.presentation.theme.LayersTheme
import com.example.layers.presentation.theme.Screen
import com.example.layers.presentation.theme.ui.user_detail.UserDetailScreen
import com.example.layers.presentation.theme.ui.user_list.UserListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayersTheme {
                // FIXME: გამოიყენე scaffold გაარკვიე რატო და როგორ
                // FIXME : სარფეისის გამოყენება არაა  აქ საჭირო ზოგადად სარფეისი კომპონენტების აწყობისას თუ გამოგადგება ისე არა
                Surface(color = MaterialTheme.colorScheme.background){
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = Screen.UserListScreen.route){
                        // FIXME: ეს კომპუზებლ ფუნქციები რომლებსაც იყენებ არის ძველი პრაქტიკებით ახალზე გადააწყე დაახლოებით ასე composable<SCREENROUTE>(){....}
                        // FIXME: სქრინს ნავ კონტროლერი არ უნდა ჩააწოდო ლამბდის მეშვეობით უნდა დააბრუნო ქოლბექი და გარეთ დაჰენდლო
                        composable(route = Screen.UserListScreen.route) {
                            UserListScreen(navController)
                        }
                        composable(route = Screen.UserDetailScreen.route + "/{userLogin}") {
                            UserDetailScreen()
                        }
                    }
                }
            }
        }
    }
}