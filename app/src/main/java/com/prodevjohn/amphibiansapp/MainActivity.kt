package com.prodevjohn.amphibiansapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prodevjohn.amphibiansapp.ui.AmphibiansApp
import com.prodevjohn.amphibiansapp.ui.AmphibiansViewModel
import com.prodevjohn.amphibiansapp.ui.theme.AmphibiansAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansAppTheme {
                val viewModel : AmphibiansViewModel = viewModel(factory = AmphibiansViewModel.Factory)
                AmphibiansApp(amphibiansViewModel = viewModel)
            }
        }
    }
}
