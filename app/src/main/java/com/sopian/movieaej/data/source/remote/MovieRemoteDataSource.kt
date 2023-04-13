package com.sopian.movieaej.data.source.remote

import com.sopian.movieaej.data.source.remote.response.MovieResponse

interface MovieRemoteDataSource {
    suspend fun getUpcomingMovies(): List<MovieResponse>
}