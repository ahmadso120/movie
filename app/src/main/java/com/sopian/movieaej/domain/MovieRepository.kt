package com.sopian.movieaej.domain

import com.sopian.movieaej.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getUpcomingMovies(): Flow<List<Movie>>
}