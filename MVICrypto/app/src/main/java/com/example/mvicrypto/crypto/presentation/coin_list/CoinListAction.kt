package com.example.mvicrypto.crypto.presentation.coin_list

import com.example.mvicrypto.crypto.presentation.models.CoinUI

sealed interface CoinListAction {
    data class OnCoinCLick(val coinUI: CoinUI): CoinListAction
}