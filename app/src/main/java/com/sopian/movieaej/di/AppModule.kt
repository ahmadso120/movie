package com.sopian.movieaej.di

import com.sopian.movieaej.appinitializers.TimberInitializer
import com.sopian.movieaej.common.appinitializers.AppInitializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
class AppModule

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModuleBinds {
    @Binds
    @IntoSet
    abstract fun provideTimberInitializer(
        initializer: TimberInitializer
    ): AppInitializer

}