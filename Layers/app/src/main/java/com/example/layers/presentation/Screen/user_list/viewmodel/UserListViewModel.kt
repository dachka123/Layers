package com.example.layers.presentation.Screen.user_list.viewmodel

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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
): ViewModel() {

    var state by mutableStateOf(UserListState())
        private set

    /*init {
        getUsers()
    }*/
    fun onIntent(intent: UserListIntent) {
        when (intent) {
            is UserListIntent.LoadUsers -> getUsers()
        }
    }

    private fun getUsers(){
        viewModelScope.launch {
            getUsersUseCase().onEach { result ->
                state = when(result) {
                    is Resource.Success -> {
                        state.copy(
                            userDomains = result.data ?: emptyList(),
                            isLoading = false,
                            error = ""
                        )
                    }
                    is Resource.Error -> {
                        state.copy(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        state.copy(isLoading = true)
                    }
                }
            }.launchIn(this)
        }
    }
}