package com.example.tradeonline.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.tradeonline.data.persistence.AppDatabase
import com.example.tradeonline.data.persistence.TrendLineDao
import com.example.tradeonline.utils.Constants
import com.example.tradeonline.utils.analytics.AnalyticsHelper
import com.example.tradeonline.utils.analytics.FirebaseAnalyticsHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {


    @Provides
    @Singleton
    fun providesFirebaseAnalyticsHelper(context: Context): AnalyticsHelper =
        FirebaseAnalyticsHelper(context)


    @Provides
    fun provideAppDatabase(
        application: Application
    ): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, Constants.App.DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideTrendLineDao(appDatabase: AppDatabase): TrendLineDao {
        return appDatabase.trendLineDao()
    }

}