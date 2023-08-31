package com.sopian.teravinassessment.core.data.source.remote

import com.sopian.teravinassessment.core.data.source.remote.exception.ApiException
import com.sopian.teravinassessment.core.data.source.remote.network.ApiService
import com.sopian.teravinassessment.core.data.source.remote.response.MovieResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun fetchMovies(): List<MovieResponse> {
        return try {
            apiService.getMovies().results
        } catch (exception: Exception) {
            throw ApiException("Failed to fetch movies from API", exception)
        }
    }
}