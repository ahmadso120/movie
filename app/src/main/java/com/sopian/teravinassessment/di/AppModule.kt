package com.sopian.teravinassessment.di

import android.content.Context
import android.content.SharedPreferences
import com.sopian.teravinassessment.core.domain.repository.MovieRepository
import com.sopian.teravinassessment.core.domain.usecase.MovieInteractor
import com.sopian.teravinassessment.core.domain.usecase.MovieUseCase
import com.sopian.teravinassessment.core.utils.ConnectivityManagerNetworkMonitor
import com.sopian.teravinassessment.core.utils.NetworkMonitor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMovieUseCase(repository: MovieRepository): MovieUseCase = MovieInteractor(repository)

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideConnectivityManagerNetworkMonitor(@ApplicationContext context: Context): NetworkMonitor {
        return ConnectivityManagerNetworkMonitor(context)
    }
}