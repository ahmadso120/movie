package com.sopian.movieaej.data.source.remote.network

import com.sopian.movieaej.data.source.remote.response.BaseResponse
import com.sopian.movieaej.data.source.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): BaseResponse<List<MovieResponse>>
}