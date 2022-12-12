package com.prodevjohn.amphibiansapp

import android.app.Application
import com.prodevjohn.amphibiansapp.data.AppContainer
import com.prodevjohn.amphibiansapp.data.DefaultAppContainer

class AmphibiansApplication: Application() {

    /** AppContainer instance used by the rest of the classes to obtain dependencies */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
