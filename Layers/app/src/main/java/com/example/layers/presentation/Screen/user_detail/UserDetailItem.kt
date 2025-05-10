package com.example.layers.presentation.Screen.user_detail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.layers.R
import com.example.layers.domain.model.UserDetailDomain

@Composable
fun UserDetailItem(
    userDetailDomain: UserDetailDomain,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "${userDetailDomain.userLogin}, " +
                    "${userDetailDomain.followers} ${stringResource(id = R.string.followers)}, " +
                    "${userDetailDomain.following} ${stringResource(id = R.string.following)}"
        )
    }
}