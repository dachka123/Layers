package com.example.layers.di

import com.example.layers.BuildConfig
import com.example.layers.data.remote.UserApi
import com.example.layers.data.repository.NetworkHandler
import com.example.layers.data.repository.UserRepositoryImpl
import com.example.layers.domain.repository.UserRepository
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
    val baseUrl = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserRepository(api:UserApi,handler: NetworkHandler): UserRepository{
        return UserRepositoryImpl(api,handler)
    }

    @Provides
    @Singleton
    fun provideNetworkResourceHandler(): NetworkHandler {
        return NetworkHandler()
    }
}