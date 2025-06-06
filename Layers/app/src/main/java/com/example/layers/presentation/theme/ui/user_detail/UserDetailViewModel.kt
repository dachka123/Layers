package com.example.layers.presentation.theme.ui.user_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.layers.common.Constants
import com.example.layers.common.Resource
import com.example.layers.domain.use_case.getUser.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    // FIXME: ისე კაი იქნება თუ ჩახედავ ბეიზვიუმოდელს და მაგის უსქეისებს
    //  კაი იქნება თუ MVI design pattern-ს მოიძიებ აქ პატარა ვიუმოდელია
    //  თუმცა უეჭველი დაგჭირდება 99% შემთხვევებში

    // FIXME: რატო mutablestateof და არა MutableStateFlow
    //  რა სხვაობაა და რითი ჯობია ერთი მეორეს
    //  როდის რომელი უნდა გამოიყენო და ა.შ.
    var state by mutableStateOf(UserDetailState())
        private set

    init {
        savedStateHandle.get<String>(Constants.PARAM_USER_ID)?.let { userLogin ->
            getUser(userLogin)
        }
    }

    // FIXME: აქაც იგივე რაც წინა ვიუმოდელში
    private fun getUser(userLogin: String){
        getUserUseCase(userLogin).onEach { result ->
            when(result){
                is Resource.Success -> {
                    state = UserDetailState(user = result.data)
                }
                is Resource.Error -> {
                    state = UserDetailState(error = result.message ?: "unexpected error occured")
                }
                is Resource.Loading ->{
                    state = UserDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}