package com.example.myapplication.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.Resource
import com.example.myapplication.domain.model.Ticker
import com.example.myapplication.domain.usecase.GetTickersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

data class HomeUiState(
    val isLoading: Boolean = false,
    val tickers: List<Ticker> = emptyList(),
    val error: String = "",
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTickersUseCase: GetTickersUseCase
) : ViewModel() {
    private val _UiState = mutableStateOf<HomeUiState>(HomeUiState())
    val uiState: State<HomeUiState> = _UiState

    init {
        getTickers()
    }

    private fun getTickers() {
        getTickersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _UiState.value = HomeUiState(tickers = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _UiState.value = HomeUiState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _UiState.value = HomeUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}