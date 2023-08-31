package com.sopian.teravinassessment.core.data.source.local

import com.sopian.teravinassessment.core.data.source.local.entity.MovieEntity
import com.sopian.teravinassessment.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val movieDao: MovieDao) {
    suspend fun clearAllMovies() = movieDao.deleteMovies()
    suspend fun saveMovies(movies: List<MovieEntity>) = movieDao.insertMovies(movies)
    fun getMovies(): Flow<List<MovieEntity>> = movieDao.getMovies()
}