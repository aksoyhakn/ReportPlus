package com.example.tradeonline.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.tradeonline.app.initializers.AppInitializers
import com.example.tradeonline.di.DaggerAppInitializerComponent
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@ExperimentalCoroutinesApi
@HiltAndroidApp
class TrendLineApp : Application() {

    @Inject
    lateinit var initializers: AppInitializers

    override fun onCreate() {
        super.onCreate()
        DaggerAppInitializerComponent.builder().build()
        initializers.init(this)
        instance = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    companion object {
        lateinit var instance: TrendLineApp
    }
}
