package com.example.mvicrypto.crypto.presentation.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.mvicrypto.crypto.presentation.coin_list.CoinListAction
import com.example.mvicrypto.crypto.presentation.coin_list.CoinListState
import com.example.mvicrypto.ui.theme.MVICryptoTheme

@Composable
fun CoinListScreen(
    state: CoinListState,
    onAction: (CoinListAction) -> Unit,
    modifier: Modifier = Modifier
) {

    if(state.isLoading){
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        LazyColumn(
            modifier = modifier.fillMaxSize(),
        ) {
            items(state.coins){coinUI ->
                CoinListItem(
                    coinUI = coinUI,
                    onClick = {
                        onAction(CoinListAction.OnCoinCLick(coinUI))
                    }
                )
                HorizontalDivider()
            }
        }
    }
}


@PreviewLightDark
@Composable
private fun CoinListScreenPreview() {
    MVICryptoTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1..100).map{
                    previewCoin.copy(id = it.toString())
                }
            ),
            onAction = {}
        )
    }
}