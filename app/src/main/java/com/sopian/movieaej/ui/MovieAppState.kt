package com.sopian.movieaej.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun rememberMovieAppState(
    navController: NavHostController = rememberNavController()
): MovieAppState {
    return remember(navController) {
        MovieAppState(navController)
    }
}

@Stable
class MovieAppState(
    val navController: NavHostController
) {

}