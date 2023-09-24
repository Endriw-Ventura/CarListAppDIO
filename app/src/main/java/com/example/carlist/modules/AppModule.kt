package com.example.carlist.modules

import com.example.carlist.consts.Consts
import com.example.carlist.data.api.CarAPI
import com.example.carlist.repository.CarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

class AppModule {
    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {

        @Provides
        @Singleton
        fun provideCarRepository(
            api: CarAPI
        ) = CarRepository(api)

        @Provides
        @Singleton
        fun provideCarAPI() : CarAPI{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Consts.BASE_URL)
                .build()
                .create(CarAPI::class.java)
        }
    }
}



