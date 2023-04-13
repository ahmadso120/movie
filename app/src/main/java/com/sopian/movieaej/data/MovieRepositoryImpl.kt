package com.sopian.movieaej.data

import com.sopian.movieaej.data.source.remote.MovieRemoteDataSource
import com.sopian.movieaej.data.source.remote.response.asExternalModel
import com.sopian.movieaej.domain.model.Movie
import com.sopian.movieaej.domain.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val dataSource: MovieRemoteDataSource
) : MovieRepository {
    override fun getUpcomingMovies(): Flow<List<Movie>> = flow {
        emit(dataSource.getUpcomingMovies().map { it.asExternalModel() })
    }
}