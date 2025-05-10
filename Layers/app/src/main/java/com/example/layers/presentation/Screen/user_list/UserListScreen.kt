package com.example.layers.presentation.Screen.user_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.layers.presentation.Screen.user_list.viewmodel.UserListIntent
import com.example.layers.presentation.Screen.user_list.viewmodel.UserListViewModel
import kotlinx.serialization.Serializable

@Composable
fun UserListScreen(
    onUserClick: (String) -> Unit,
    viewModel: UserListViewModel = hiltViewModel()
){
    val state = viewModel.state

    LaunchedEffect(Unit) {
        viewModel.onIntent(UserListIntent.LoadUsers)
    }

    Box(modifier = Modifier.fillMaxWidth()) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.userDomains){ user ->
                UserListItem(
                    userDomain = user,
                    onItemClick = {
                        onUserClick(user.login)
                    }
                )
            }
        }
        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}