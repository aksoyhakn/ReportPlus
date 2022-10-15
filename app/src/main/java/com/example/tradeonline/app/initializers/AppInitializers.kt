package com.example.tradeonline.app.initializers

import android.app.Application
import com.example.tradeonline.app.initializers.AppInitializer
import javax.inject.Inject


/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


class AppInitializers @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>
) {
    fun init(application: Application) {
        initializers.forEach {
            it.init(application)
        }
    }
}