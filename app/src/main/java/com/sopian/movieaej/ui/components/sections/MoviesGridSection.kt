package com.sopian.movieaej.ui.components.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopian.movieaej.domain.model.Movie
import com.sopian.movieaej.ui.components.items.MovieCardItem

@Composable
fun MoviesGridSection(
    states: List<Movie>,
    contentPadding: PaddingValues = PaddingValues(8.dp),
) {
    Box(modifier = Modifier) {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = contentPadding,
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(states) {
                MovieCardItem(it)
            }
        }
    }
}