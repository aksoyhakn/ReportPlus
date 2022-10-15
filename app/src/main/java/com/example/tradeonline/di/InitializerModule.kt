package com.example.tradeonline.di

import com.example.tradeonline.app.initializers.AppInitializer
import com.example.tradeonline.app.initializers.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet


/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Module
@InstallIn(SingletonComponent::class)
object InitializerModule {

    @Provides
    @IntoSet
    fun provideFirebaseInitializer(): AppInitializer = FirebaseInitializer()

    @Provides
    @IntoSet
    fun provideCrashlyticsInitializer(): AppInitializer = CrashlyticsInitializer()
}
