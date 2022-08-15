package com.wenger.natifetesttask.api

import com.wenger.natifetesttask.model.TrendingGifResponse
import com.wenger.natifetesttask.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GifsApi {

    @GET("gifs/trending")
    suspend fun getAllTrendingGifs(
        @Query("api_key")
        apiKey: String = Constants.API_KEY
    ) : Response<TrendingGifResponse>
}