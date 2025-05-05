package com.example.layers.presentation.theme.ui.user_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.layers.common.Resource
import com.example.layers.domain.use_case.getUsers.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val GetUsersUseCase: GetUsersUseCase
): ViewModel() {

    var state by mutableStateOf(UserListState())
        private set

    init {
        getUsers()
    }

    private fun getUsers(){
        GetUsersUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    state = UserListState(users = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    state = UserListState(error = result.message ?: "unexpected error occured")
                }
                is Resource.Loading ->{
                    state = UserListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}