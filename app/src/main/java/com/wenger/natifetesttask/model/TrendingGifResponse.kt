package com.wenger.natifetesttask.model

import com.google.gson.annotations.SerializedName

data class TrendingGifResponse(
    @SerializedName("data") val data: List<GifResponse>
)

data class GifResponse(
    @SerializedName("id") val id: String,
    @SerializedName("images") val images: ImagesResponse,
    @SerializedName("title") val title: String,
)

data class ImagesResponse(
    @SerializedName("fixed_width") val fixedWidth: ImageSizeResponse,
    @SerializedName("fixed_height") val fixedHeight: ImageSizeResponse,
    @SerializedName("original") val original: ImageSizeResponse
)

data class ImageSizeResponse(
    @SerializedName("url") val url: String
)
