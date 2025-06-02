package com.example.mvicrypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.mvicrypto.core.navigation.AdaptiveCoinListDetailPane
import com.example.mvicrypto.ui.theme.MVICryptoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVICryptoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdaptiveCoinListDetailPane(
                         modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}