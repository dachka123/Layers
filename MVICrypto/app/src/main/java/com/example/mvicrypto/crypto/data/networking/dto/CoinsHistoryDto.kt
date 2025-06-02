package com.example.mvicrypto.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinsHistoryDto(
    val data: List<CoinPriceDto>
)