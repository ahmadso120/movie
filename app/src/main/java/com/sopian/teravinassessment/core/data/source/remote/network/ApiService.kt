package com.sopian.teravinassessment.core.data.source.remote.network

import com.sopian.teravinassessment.core.data.source.remote.response.BaseResponse
import com.sopian.teravinassessment.core.data.source.remote.response.MovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("discover/movie?api_key=f7b67d9afdb3c971d4419fa4cb667fbf")
    suspend fun getMovies(): BaseResponse<List<MovieResponse>>
}