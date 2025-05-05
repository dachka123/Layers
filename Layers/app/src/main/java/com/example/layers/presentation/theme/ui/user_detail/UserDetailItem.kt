package com.example.layers.presentation.theme.ui.user_detail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.layers.domain.model.UserDetail

@Composable
fun UserDetailItem(
    userDetail: UserDetail
) {

    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "name:${userDetail.userLogin}, followers:${userDetail.followers}, followings:${userDetail.following}"
        )
    }
}