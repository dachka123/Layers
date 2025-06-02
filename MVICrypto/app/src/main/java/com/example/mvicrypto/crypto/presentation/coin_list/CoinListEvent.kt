package com.example.mvicrypto.crypto.presentation.coin_list

import com.example.mvicrypto.core.domain.util.NetworkError

interface CoinListEvent {

    data class Error(val error: NetworkError): CoinListEvent
}