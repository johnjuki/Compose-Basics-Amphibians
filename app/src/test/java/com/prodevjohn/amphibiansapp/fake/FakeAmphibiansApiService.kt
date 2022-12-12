package com.prodevjohn.amphibiansapp.fake

import com.prodevjohn.amphibiansapp.model.Amphibian
import com.prodevjohn.amphibiansapp.network.AmphibiansApiService

class FakeAmphibiansApiService : AmphibiansApiService {
    override suspend fun getAmphibiansData(): List<Amphibian> {
        return FakeDataSource.amphibiansList
    }
}
