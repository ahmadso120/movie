package com.sopian.teravinassessment.core.di

import com.sopian.teravinassessment.core.data.MovieRepositoryImpl
import com.sopian.teravinassessment.core.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideMovieRepository(movieRepository: MovieRepositoryImpl): MovieRepository

}