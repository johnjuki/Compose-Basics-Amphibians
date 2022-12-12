package com.prodevjohn.amphibiansapp.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.prodevjohn.amphibiansapp.network.AmphibiansApiService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

/**
 * Dependency injection container at the application level.
 */
interface AppContainer {
    val amphibiansRepository : AmphibiansRepository
}

/**
 * Implementation for the Dependency Injection container at the application level.
 *
 * Variables are initialized lazily and the same instance is shared across the whole app.
 */
class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: AmphibiansApiService by lazy { retrofit.create(AmphibiansApiService::class.java)}

    /**
     * DI implementation for [AmphibiansRepository]
     */
    override val amphibiansRepository: AmphibiansRepository by lazy { NetworkAmphibiansRepository(retrofitService) }
}
