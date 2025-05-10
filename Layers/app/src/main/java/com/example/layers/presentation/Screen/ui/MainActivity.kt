package com.example.layers.presentation.Screen.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.layers.presentation.theme.LayersTheme
import com.example.layers.presentation.Screen.user_detail.UserDetailScreen
import com.example.layers.presentation.Screen.user_list.UserListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayersTheme {
                val navController = rememberNavController()
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = StartScreen,
                        modifier = androidx.compose.ui.Modifier.padding(paddingValues)
                    ) {
                        composable<StartScreen>{
                            UserListScreen(
                                onUserClick = { login ->
                                    navController.navigate(UserDetailRoute(login))
                                }
                            )
                        }
                        composable<UserDetailRoute> { backStackEntry ->
                            val args = backStackEntry.arguments
                            val userLogin = args?.getString("userLogin") ?: return@composable
                            UserDetailScreen(userLogin = userLogin)
                        }
                        /*composable(route = Screen.UserListScreen.route) {
                            UserListScreen(navController)
                        }
                        composable(route = Screen.UserDetailScreen.route + "/{userLogin}") {backStackEntry ->
                            val userLogin = backStackEntry.arguments?.getString("userLogin") ?: ""
                            UserDetailScreen(userLogin = userLogin)
                        }*/
                    }
                }
            }
        }
    }
}