package com.example.layers.data.remote.dto

import com.example.layers.domain.model.UserDetail

//FIXME: ქვედა ტირეთი არ შეიძლება კლასის წევრები რო გეწეროს ქემელქეისი უნდა
//FIXME: გაარკვიე ეგ როგორ უნდა ქნა
//  თუ ყველა ატრიბუტი არ გჭირდება DTO მოდელში ტყუილად არ უნდა გქონდეს დაწერილი
data class UserDetailDto(
    val avatar_url: String,
    val blog: String,
    val company: String,
    val created_at: String,
    val events_url: String,
    val followers: Int,
    val followers_url: String,
    val following: Int,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val location: String,
    val login: String,
    val name: String,
    val node_id: String,
    val organizations_url: String,
    val public_gists: Int,
    val public_repos: Int,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val twitter_username: String,
    val type: String,
    val updated_at: String,
    val url: String,
    val user_view_type: String
)

// FIXME: მაპერს როგორც წესი ისეთი სახელი უნდა ქონდეს რო მიახვედრებდეს სად
//  იმაპება მაგ. toDto , toDomain, toEntity, toPresentation
//  შესაბამისად toUserDetailDomain უნდა ერქვას ცალკეც დაგიწერე მაგაზე
//  ეს ცოტა მიდგომის საკითხია თუმცა კარგი იქნება რო ეს მაპერი ცალკე ფაილში იყოს
fun UserDetailDto.toUserDetail(): UserDetail{
    return UserDetail(
        userLogin = login,
        followers = followers,
        following = following
    )
}
