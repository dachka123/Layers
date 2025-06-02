package com.example.mvicrypto.di

import com.example.mvicrypto.core.data.networking.HttpClientFactory
import com.example.mvicrypto.crypto.data.networking.RemoteCoinDataSource
import com.example.mvicrypto.crypto.domain.CoinDataSource
import com.example.mvicrypto.crypto.presentation.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}