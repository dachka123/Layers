package com.example.mvicrypto.crypto.domain

import com.example.mvicrypto.core.domain.util.NetworkError
import com.example.mvicrypto.core.domain.util.Result
import java.time.ZonedDateTime

interface CoinDataSource {

    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>

}