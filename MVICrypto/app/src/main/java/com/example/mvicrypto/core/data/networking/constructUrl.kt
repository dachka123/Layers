package com.example.mvicrypto.core.data.networking

import com.example.mvicrypto.BuildConfig

fun constructUrl(url: String): String{
    /*return when{
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url
        else -> BuildConfig.BASE_URL + url
    }*/
    return if (url.startsWith("/")) BuildConfig.BASE_URL + url else url
}