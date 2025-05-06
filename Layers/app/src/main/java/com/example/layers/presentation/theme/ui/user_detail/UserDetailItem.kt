package com.example.layers.presentation.theme.ui.user_detail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.layers.domain.model.UserDetail

// FIXME: ფექიჯები გაასწორე სქრინებისთვის theme/ui ში რომ გაქვს არ არის სწორი
//  სქრინის ფექიჯი შექმენი  პრეზენტეიშენში და იქ ჩაყარე მერე სქრინები

@Composable
fun UserDetailItem(
    userDetail: UserDetail
) {
    // FIXME: მოდიფაიერი უნდა ჩააწოდო და ეგ მოდიფაიერი დაუსეტე ყველაზე გარეთა კომპოუზებლს 
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        // FIXME: სტრინგები რესურსებში გაიტანე ასე სტატიკურად არ უნდა გქონდეს გაარკვიე როგორ უნდა ქნა 
        Text(
            text = "name:${userDetail.userLogin}, followers:${userDetail.followers}, followings:${userDetail.following}"
        )
    }
}