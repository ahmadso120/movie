package com.sopian.movieaej.feature.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopian.movieaej.domain.GetUpcomingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val useCase: GetUpcomingMoviesUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<MoviesUiState> =
        MutableStateFlow(MoviesUiState.Loading)
    val uiState: StateFlow<MoviesUiState> = _uiState.asStateFlow()

    init {
        getUpcomingMovies()
    }

    private fun getUpcomingMovies() = viewModelScope.launch {
        useCase()
            .onStart {
                _uiState.emit(MoviesUiState.Loading)
            }
            .catch {
                _uiState.emit(MoviesUiState.Error(it.message.toString()))
            }
            .collect {
                _uiState.emit(MoviesUiState.Success(it))
            }
    }
}