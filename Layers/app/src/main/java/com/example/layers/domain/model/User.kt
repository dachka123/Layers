package com.example.layers.domain.model

// FIXME: ქვედა ტირე არ უნდა იყოს სახელში
//  ასევე დომეინის კლასი რომ არის ეგ უნდა ჩანდეს
//  Domain უნდა ეწეროს სახელის ბოლოში (UserDomain)
data class User(
    val id: Int,
    val login: String,
    val avatar_url: String
)

