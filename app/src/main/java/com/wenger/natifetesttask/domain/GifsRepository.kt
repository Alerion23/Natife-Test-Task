package com.wenger.natifetesttask.domain

import com.wenger.natifetesttask.api.GifsApi
import com.wenger.natifetesttask.model.TrendingGifResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class GifsRepository @Inject constructor(
    private val api: GifsApi
) : IGifsRepository {

    override suspend fun getAllGifs(): Response<TrendingGifResponse> {
        return withContext(Dispatchers.IO) {
            api.getAllTrendingGifs()
        }
    }
}