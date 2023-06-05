package com.zahra.data.di

import android.content.Context
import android.util.Log
import com.zahra.data.BuildConfig
import com.zahra.data.remotedata.ApiService
import com.zahra.data.remotedata.ApiService.Companion.BASE_URL
import com.zahra.data.remotedata.takeawayapi.StringProvider
import com.zahra.data.remotedata.takeawayapi.StringProviderImpl
import com.zahra.data.remotedata.takeawayapi.TakeAwayRemoteDataSource
import com.zahra.data.remotedata.takeawayapi.TakeAwayRemoteDataSourceImp
import com.zahra.data.repository.TakeAwayRepositoryImp
import com.zahra.domain.repository.TakeAwayRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor { message ->
            Log.d("okHttpLog", message)
        }.apply {
            setLevel(
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BASIC
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            )
        }

        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitApi(client: OkHttpClient): ApiService {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideStringProvider(@ApplicationContext appContext: Context): StringProvider {
        return StringProviderImpl(appContext)
    }

    @Provides
    @Singleton
    fun provideTakeAwayRemoteDataSource(api: ApiService,stringProvider: StringProvider): TakeAwayRemoteDataSource {
        return TakeAwayRemoteDataSourceImp(api,stringProvider)
    }

    @Provides
    @Singleton
    fun provideTakeAwayRepository(remoteDataSource: TakeAwayRemoteDataSource): TakeAwayRepository {
        return TakeAwayRepositoryImp(remoteDataSource)
    }

}
