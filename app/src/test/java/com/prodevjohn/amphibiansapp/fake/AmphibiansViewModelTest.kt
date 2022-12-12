package com.prodevjohn.amphibiansapp.fake

import com.prodevjohn.amphibiansapp.rules.TestDispatcherRule
import com.prodevjohn.amphibiansapp.ui.AmphibiansUiState
import com.prodevjohn.amphibiansapp.ui.AmphibiansViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AmphibiansViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun amphibiansViewModel_getAmphibiansData_verifyAmphibiansUiStateSuccess() = runTest {
        val amphibiansViewModel =
            AmphibiansViewModel(amphibiansRepository = FakeNetworkAmphibiansRepository())
        assertEquals(
            AmphibiansUiState.Success(FakeDataSource.amphibiansList),
            amphibiansViewModel.amphibiansUiState
        )
    }
}
