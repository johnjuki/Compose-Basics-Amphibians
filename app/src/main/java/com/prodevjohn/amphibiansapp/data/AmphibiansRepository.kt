package com.prodevjohn.amphibiansapp.data

import com.prodevjohn.amphibiansapp.model.Amphibian
import com.prodevjohn.amphibiansapp.network.AmphibiansApiService

/**
 * Repository retrieves amphibian data from underlying data source.
 */
interface AmphibiansRepository {
    /** Retrieves list of amphibians from underlying data source */
    suspend fun getAmphibiansData() : List<Amphibian>
}

/**
 * Network implementation of repository that retrieves amphibian data from underlying data source.
 */
class NetworkAmphibiansRepository(private val amphibiansApiService: AmphibiansApiService) : AmphibiansRepository {
    override suspend fun getAmphibiansData(): List<Amphibian> {
        return amphibiansApiService.getAmphibiansData()
    }
}
