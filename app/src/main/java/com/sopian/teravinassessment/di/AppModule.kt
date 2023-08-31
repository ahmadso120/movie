package com.sopian.teravinassessment.di

import android.content.Context
import android.content.SharedPreferences
import com.sopian.teravinassessment.core.domain.repository.MovieRepository
import com.sopian.teravinassessment.core.domain.usecase.MovieInteractor
import com.sopian.teravinassessment.core.domain.usecase.MovieUseCase
import com.sopian.teravinassessment.core.utils.AlarmHandler
import com.sopian.teravinassessment.core.utils.AlarmManagerHandlerImpl
import com.sopian.teravinassessment.core.utils.ConnectivityManagerNetworkMonitor
import com.sopian.teravinassessment.core.utils.NetworkMonitor
import com.sopian.teravinassessment.core.utils.NotificationHandler
import com.sopian.teravinassessment.core.utils.NotificationManager
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
    fun provideAlarmManagerHandler(
        @ApplicationContext context: Context
    ): AlarmHandler = AlarmManagerHandlerImpl(context)

    @Singleton
    @Provides
    fun provideNotificationManger(): NotificationHandler = NotificationManager()

    @Provides
    @Singleton
    fun provideConnectivityManagerNetworkMonitor(@ApplicationContext context: Context): NetworkMonitor {
        return ConnectivityManagerNetworkMonitor(context)
    }
}