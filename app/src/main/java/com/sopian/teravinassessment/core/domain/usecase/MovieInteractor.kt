package com.sopian.teravinassessment.core.domain.usecase

import com.sopian.teravinassessment.core.domain.model.Movie
import com.sopian.teravinassessment.core.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieInteractor @Inject constructor(
    private val movieRepository: MovieRepository
) : MovieUseCase {
    override suspend fun updateMovies() = movieRepository.updateMovies()

    override fun getMovies(): Flow<List<Movie>> = movieRepository.getMovies()
}