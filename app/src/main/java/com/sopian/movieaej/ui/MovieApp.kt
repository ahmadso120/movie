package com.sopian.movieaej.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.sopian.movieaej.feature.movies.MovieScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp() {
    Scaffold { padding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            color = MaterialTheme.colorScheme.background
        ) {
            MovieScreen()
        }
    }
}

