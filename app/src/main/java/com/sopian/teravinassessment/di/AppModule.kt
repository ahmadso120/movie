package com.sopian.teravinassessment.di

import com.sopian.teravinassessment.core.domain.repository.MovieRepository
import com.sopian.teravinassessment.core.domain.usecase.MovieInteractor
import com.sopian.teravinassessment.core.domain.usecase.MovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideMovieUseCase(repository: MovieRepository): MovieUseCase = MovieInteractor(repository)
}