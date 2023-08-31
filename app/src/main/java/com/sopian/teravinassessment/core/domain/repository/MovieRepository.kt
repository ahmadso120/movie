package com.sopian.teravinassessment.core.domain.repository

import com.sopian.teravinassessment.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun updateMovies()
    fun getMovies(): Flow<List<Movie>>
}