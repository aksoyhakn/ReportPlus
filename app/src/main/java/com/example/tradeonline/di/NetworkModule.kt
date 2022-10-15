package com.example.tradeonline.di

import android.app.Application
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.tradeonline.BuildConfig
import com.example.tradeonline.app.TrendLineApp
import com.example.tradeonline.data.preference.PreferenceHelper
import com.example.tradeonline.data.preference.PreferenceHelperImp
import com.example.tradeonline.data.service.LoggingInterceptor
import com.example.tradeonline.data.service.TrendLineDataSource
import com.example.tradeonline.data.service.TrendLineService
import com.example.tradeonline.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    internal fun providePrefFileName(): String = Constants.App.PREF_NAME

    @Provides
    internal fun providePrefHelper(appPreferenceHelper: PreferenceHelperImp): PreferenceHelper =
        appPreferenceHelper

    @Provides
    fun provideContext(application: Application): Context =
        TrendLineApp.instance.applicationContext

    @Provides
    fun provideChuckInterceptor(application: Application) = ChuckerInterceptor(application)

    @Provides
    fun provideInterceptor(context: Context) = LoggingInterceptor(
        PreferenceHelperImp(context, providePrefFileName())
    )

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: LoggingInterceptor,
        chuckInterceptor: ChuckerInterceptor
    ): OkHttpClient {
        if (BuildConfig.GADGET_ENABLED) {
            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(chuckInterceptor)
                .build()
        } else {
            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build()
        }
    }


    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }


    @Provides
    @Singleton
    fun provideTradeOnlineService(okHttpClient: OkHttpClient): TrendLineService {
        return provideRetrofit(okHttpClient).create(TrendLineService::class.java)
    }

    @Provides
    @Singleton
    fun provideTrendLineClient(
        trendLineService: TrendLineService
    ): TrendLineDataSource {
        return TrendLineDataSource(trendLineService)
    }
}