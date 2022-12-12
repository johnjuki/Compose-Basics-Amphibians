package com.prodevjohn.amphibiansapp.fake

import com.prodevjohn.amphibiansapp.data.AmphibiansRepository
import com.prodevjohn.amphibiansapp.model.Amphibian

class FakeNetworkAmphibiansRepository: AmphibiansRepository {
    override suspend fun getAmphibiansData(): List<Amphibian> {
        return FakeDataSource.amphibiansList
    }
}
