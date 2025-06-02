package com.example.mvicrypto.crypto.data.networking

import com.example.mvicrypto.BuildConfig
import com.example.mvicrypto.core.data.networking.constructUrl
import com.example.mvicrypto.core.data.networking.safeCall
import com.example.mvicrypto.core.domain.util.NetworkError
import com.example.mvicrypto.core.domain.util.Result
import com.example.mvicrypto.core.domain.util.map
import com.example.mvicrypto.crypto.data.mappers.toCoin
import com.example.mvicrypto.crypto.data.mappers.toCoinPrice
import com.example.mvicrypto.crypto.data.networking.dto.CoinResponseDto
import com.example.mvicrypto.crypto.data.networking.dto.CoinsHistoryDto
import com.example.mvicrypto.crypto.domain.Coin
import com.example.mvicrypto.crypto.domain.CoinDataSource
import com.example.mvicrypto.crypto.domain.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val httpClient: HttpClient,

): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(constructUrl("/assets")){
                parameter("apiKey", BuildConfig.COINCAP_API_KEY)
            }
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()
        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinsHistoryDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinId/history")
            ){
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end",endMillis)
            }
        }.map{response->
            response.data.map { it.toCoinPrice() }

        }
    }
}