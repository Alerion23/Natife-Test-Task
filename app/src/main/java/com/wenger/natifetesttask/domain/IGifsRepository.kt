package com.wenger.natifetesttask.domain

import com.wenger.natifetesttask.model.TrendingGifResponse
import retrofit2.Response

interface IGifsRepository {

    suspend fun getAllGifs(): Response<TrendingGifResponse>

}