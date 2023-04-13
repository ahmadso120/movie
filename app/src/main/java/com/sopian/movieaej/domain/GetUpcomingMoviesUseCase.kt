package com.sopian.movieaej.domain

import com.sopian.movieaej.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
){
    operator fun invoke(): Flow<List<Movie>> {
        return repository.getUpcomingMovies()
    }
}