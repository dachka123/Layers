package com.example.layers.data.remote

import com.example.layers.data.remote.dto.UserDetailDto
import com.example.layers.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    // FIXME: ზოგადად ჯობია რო ეს ენდფოინთები გაიტანო კონსტანტებად კომპანიონ ობჯექტში
    @GET("/users.json")
    suspend fun getUsers(): List<UserDto>

    @GET("/user/{userLogin}.json")
    // FIXME: ფუნქციამ პირდაპირ დტო კლასი არ უნდა დააბრუნოს არსებობს
    //  ესეთი კლასი response გაარკვიე როგორ და რატო უნდა გამოიყენო იგივე ეხება ზევით ლისტსაც
    suspend fun getUserByName(@Path("userLogin") userLogin: String): UserDetailDto
}