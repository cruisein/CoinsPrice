package com.example.myapplication.di

import com.example.myapplication.common.Constants
import com.example.myapplication.data.remote.BinanceApi
import com.example.myapplication.data.repository.TickerRepositoryImpl
import com.example.myapplication.domain.repository.TickerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBinanceApi(): BinanceApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinanceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTickerRepository(api: BinanceApi) : TickerRepository {
        return TickerRepositoryImpl(api)
    }
}