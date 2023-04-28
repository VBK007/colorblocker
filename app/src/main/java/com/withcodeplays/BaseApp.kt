package com.withcodeplays

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import androidx.viewbinding.BuildConfig
import com.withcodeplays.utils.LocaleManager
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BaseApp:Application() {
    companion object {
        lateinit var instance: BaseApp
    }
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG)
        {
            Timber.plant(Timber.DebugTree())
        }

        instance = this
    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(LocaleManager.setLocale(base!!))
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.setLocale(this)
    }
}