package com.prodevjohn.amphibiansapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.prodevjohn.amphibiansapp.R
import com.prodevjohn.amphibiansapp.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibiansApp(amphibiansViewModel: AmphibiansViewModel, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(stringResource(R.string.amphibians))
                },
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(
                amphibiansUiState = amphibiansViewModel.amphibiansUiState,
                retryAction = amphibiansViewModel::getAmphibiansData
            )
        }
    }
}
