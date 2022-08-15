package com.wenger.natifetesttask.di

import com.google.gson.Gson
import com.wenger.natifetesttask.api.ApiWorker
import com.wenger.natifetesttask.api.GifsApi
import com.wenger.natifetesttask.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideGifsApi() : GifsApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(ApiWorker.client)
        .build()
        .create(GifsApi::class.java)
}