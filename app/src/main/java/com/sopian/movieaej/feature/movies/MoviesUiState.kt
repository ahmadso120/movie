package com.sopian.movieaej.feature.movies

import com.sopian.movieaej.domain.model.Movie

sealed interface MoviesUiState {
    data class Success(val movies: List<Movie>) : MoviesUiState
    class Error(val message: String) : MoviesUiState
    object Loading : MoviesUiState
}