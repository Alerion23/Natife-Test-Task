package com.wenger.natifetesttask.di

import com.wenger.natifetesttask.api.GifsApi
import com.wenger.natifetesttask.domain.GifsRepository
import com.wenger.natifetesttask.domain.IGifsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideGifsRepository(api: GifsApi) : IGifsRepository = GifsRepository(api)

}