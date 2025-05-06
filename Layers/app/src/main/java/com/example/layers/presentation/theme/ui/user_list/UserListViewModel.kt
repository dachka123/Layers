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
    // FIXME: დიდი ასოთი არ უნდა იწყებოდეს ცვლადის სახელი
    private val GetUsersUseCase: GetUsersUseCase
) : ViewModel() {

    var state by mutableStateOf(UserListState())
        private set

    init {
        getUsers()
    }

    private fun getUsers() {
        // FIXME: მეინზე არის გაშვებული ეს არასწორია
        GetUsersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    // FIXME: ასე არ უნდა დააპდეითო სთეითი ძველი უნდა დააკოპირო და ახალი დატათი ჩაანაცვლო
                    state = UserListState(users = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    state = UserListState(error = result.message ?: "unexpected error occured")
                }

                is Resource.Loading -> {
                    // FIXME: ეს ლოადინგი არასდროს ფოლსდება
                    state = UserListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}