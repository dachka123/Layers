package com.example.layers.presentation.Screen.user_detail.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.layers.common.Resource
import com.example.layers.domain.use_case.getUser.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
): ViewModel() {

    var state by mutableStateOf(UserDetailState())
        private set

    /*init {
        savedStateHandle.get<String>(Constants.PARAM_USER_ID)?.let { userLogin ->
            getUser(userLogin)
        }
    }*/
    fun onIntent(intent: UserDetailIntent) {
        when (intent) {
            is UserDetailIntent.FetchUser -> fetchUser(intent.userLogin)
        }
    }

    private fun fetchUser(userLogin: String){
        viewModelScope.launch {
            getUserUseCase(userLogin).onEach { result ->
                state = when (result) {
                    is Resource.Success -> {
                        state.copy(
                            user = result.data,
                            isLoading = false,
                            error = ""
                        )
                    }
                    is Resource.Error -> {
                        state.copy(
                            user = result.data,
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        state.copy(
                            isLoading = true
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}