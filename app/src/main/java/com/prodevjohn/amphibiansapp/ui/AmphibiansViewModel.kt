package com.prodevjohn.amphibiansapp.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import coil.network.HttpException
import com.prodevjohn.amphibiansapp.AmphibiansApplication
import com.prodevjohn.amphibiansapp.data.AmphibiansRepository
import com.prodevjohn.amphibiansapp.model.Amphibian
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * UI state for the Home Screen
 */
sealed interface AmphibiansUiState {
    data class Success(val amphibiansData: List<Amphibian>) : AmphibiansUiState
    object Error : AmphibiansUiState
    object Loading: AmphibiansUiState
}

class AmphibiansViewModel(private val amphibiansRepository: AmphibiansRepository): ViewModel() {
    /** The mutable state that stores the status of the most recent request */
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    fun getAmphibiansData() {
        viewModelScope.launch {
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try {
                AmphibiansUiState.Success(amphibiansRepository.getAmphibiansData())
            } catch (e: IOException) {
                AmphibiansUiState.Error
            } catch (e: HttpException) {
                AmphibiansUiState.Error
            }
        }
    }

    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository)
            }
        }
    }

    init {
        getAmphibiansData()
    }
}
