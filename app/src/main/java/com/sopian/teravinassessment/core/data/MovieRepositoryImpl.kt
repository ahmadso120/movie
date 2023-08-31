package com.sopian.teravinassessment.core.data

import com.sopian.teravinassessment.core.data.source.local.LocalDataSource
import com.sopian.teravinassessment.core.data.source.local.entity.mapToDomainModel
import com.sopian.teravinassessment.core.data.source.remote.RemoteDataSource
import com.sopian.teravinassessment.core.data.source.remote.exception.ApiException
import com.sopian.teravinassessment.core.data.source.remote.response.mapToEntity
import com.sopian.teravinassessment.core.domain.model.Movie
import com.sopian.teravinassessment.core.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : MovieRepository {
    override suspend fun updateMovies() {
        try {
            val moviesFromApi = remoteDataSource.fetchMovies().map { it.mapToEntity() }
            localDataSource.clearAllMovies()
            localDataSource.saveMovies(moviesFromApi)
        } catch (exception: ApiException) {
            throw exception
        }
    }

    override fun getMovies(): Flow<List<Movie>> =
        localDataSource.getMovies().map { it.mapToDomainModel() }
}