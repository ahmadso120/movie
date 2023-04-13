package com.sopian.movieaej.feature.movies

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopian.movieaej.ui.components.items.MovieErrorItem
import com.sopian.movieaej.ui.components.items.MovieLoadingItem
import com.sopian.movieaej.ui.components.sections.MoviesGridSection

@Composable
fun MovieScreen(
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    MoviesScreenContent(uiState)
}

@Composable
private fun MoviesScreenContent(
    uiState: MoviesUiState
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when (uiState) {
            is MoviesUiState.Loading -> {
                MovieLoadingItem()
            }

            is MoviesUiState.Error -> {
                MovieErrorItem(message = uiState.message)
            }

            is MoviesUiState.Success -> {
                MoviesGridSection(uiState.movies)
            }
        }
    }

}