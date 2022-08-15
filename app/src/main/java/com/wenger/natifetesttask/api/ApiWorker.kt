package com.wenger.natifetesttask.api

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object ApiWorker {

    private var mClient: OkHttpClient? = null

    val client: OkHttpClient
        get() {
            if (mClient == null) {
                val httpBuilder = OkHttpClient.Builder()
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .build()
                mClient = httpBuilder
            }
            return mClient!!
        }
}