package com.sopian.movieaej.di

import com.sopian.movieaej.data.MovieRepositoryImpl
import com.sopian.movieaej.data.source.remote.MovieRemoteDataSource
import com.sopian.movieaej.data.source.remote.MovieRemoteDataSourceImpl
import com.sopian.movieaej.data.util.ConnectivityManagerNetworkMonitor
import com.sopian.movieaej.data.util.NetworkMonitor
import com.sopian.movieaej.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun provideMovieRemoteDataSource(
        movieRemoteDataSourceImpl: MovieRemoteDataSourceImpl
    ): MovieRemoteDataSource

    @Singleton
    @Binds
    abstract fun provideMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

    @Binds
    abstract fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor
}