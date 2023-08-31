package com.sopian.teravinassessment.core.di

import android.content.Context
import androidx.room.Room
import com.sopian.teravinassessment.core.data.source.local.room.AppDatabase
import com.sopian.teravinassessment.core.data.source.local.room.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "MovieTeravinAssessment.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieDao(database: AppDatabase): MovieDao = database.movieDao()
}