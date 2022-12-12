package com.prodevjohn.amphibiansapp.fake

import com.prodevjohn.amphibiansapp.data.NetworkAmphibiansRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkAmphibiansRepositoryTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun amphibiansRepository_getAmphibiansData_verifyAmphibiansList() = runTest {
        val repository = NetworkAmphibiansRepository(amphibiansApiService = FakeAmphibiansApiService())
        assertEquals(FakeDataSource.amphibiansList, repository.getAmphibiansData())
    }
}
