package com.sopian.teravinassessment.core.domain.usecase

import com.sopian.teravinassessment.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    suspend fun updateMovies()
    fun getMovies(): Flow<List<Movie>>
}