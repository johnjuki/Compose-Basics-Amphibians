package com.prodevjohn.amphibiansapp.network

import com.prodevjohn.amphibiansapp.model.Amphibian
import retrofit2.http.GET

/**
 * A public interface that exposes the [getAmphibiansData] method
 */
interface AmphibiansApiService {

    @GET("amphibians")
    suspend  fun getAmphibiansData() : List<Amphibian>
}
