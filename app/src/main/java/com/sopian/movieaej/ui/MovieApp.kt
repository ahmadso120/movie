package com.sopian.movieaej.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopian.movieaej.R
import com.sopian.movieaej.data.util.NetworkMonitor
import com.sopian.movieaej.feature.movies.MovieScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp(
    networkMonitor: NetworkMonitor,
    appState: MovieAppState = rememberMovieAppState(
        networkMonitor = networkMonitor
    ),
) {
    val snackbarHostState = remember { SnackbarHostState() }

    val isOffline by appState.isOffline.collectAsStateWithLifecycle()

    val notConnectedMessage = stringResource(R.string.not_connected)
    LaunchedEffect(isOffline) {
        if (isOffline) {
            snackbarHostState.showSnackbar(
                message = notConnectedMessage,
                duration = SnackbarDuration.Indefinite,
            )
        }
    }

    Scaffold (
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ){ padding ->
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

