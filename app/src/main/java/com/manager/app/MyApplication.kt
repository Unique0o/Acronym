package com.manager.app

import android.app.Application
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {


    companion object {
        private var app: MyApplication? = null
        fun getApp(): MyApplication? {
            return app
        }

    }

    override fun onCreate() {
        super.onCreate()
        app = this
        offNightMode()

    }

    private fun offNightMode() {
        val mode = if ((resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
            Configuration.UI_MODE_NIGHT_YES
        ) {
            AppCompatDelegate.MODE_NIGHT_NO
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }

        AppCompatDelegate.setDefaultNightMode(mode)
    }


}
