package com.sopian.movieaej.data.source.remote

import com.sopian.movieaej.data.source.remote.network.MoviesService
import com.sopian.movieaej.data.source.remote.response.MovieResponse
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val moviesService: MoviesService
) : MovieRemoteDataSource {
    override suspend fun getUpcomingMovies(): List<MovieResponse> {
        return moviesService.getUpcomingMovies().results ?: emptyList()
    }
}