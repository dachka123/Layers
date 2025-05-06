package com.example.layers.data.repository

import com.example.layers.data.remote.UserApi
import com.example.layers.data.remote.dto.toUser
import com.example.layers.data.remote.dto.toUserDetail
import com.example.layers.domain.model.User
import com.example.layers.domain.model.UserDetail
import com.example.layers.domain.repository.UserRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi
): UserRepository {

    // FIXME: რეპოზიტორი უნდა აბრუნებდეს რესურსიან დატას უმეტეს შემთხვევაში ფლოუს რესურსს უნდა აბრუნებდნენ
    override suspend fun getUsers(): List<User> {
        // FIXME: რეპოზიტორიში სათითაოდ რომ არ წერო ეს ექსეპშენის შემოწმება და სხვა მსგავსი რამ
        //  მიღებული პრაქტიკაა რო შექმნა ცალკე კლასი მასში ჰელპერ ფუნქცია რომელიც გააკეთებს ამ ყველაფერს
        //  მერე მაგ კლასს შეაინჯექტებ რეპოზიტორიში და გამოიყენებ დეტალები დაგუგლე
        return try{
            api.getUsers().map { it.toUser() }
        }catch (e: HttpException){
            throw Exception(e.localizedMessage ?: "An unexpected error occurred")
        }catch (e: IOException){
            throw Exception("Couldn't reach server. Check your internet connection.")
        }
    }

    override suspend fun getUserByName(userLogin: String): UserDetail {
        // FIXME: api call io დისპაჩერზე უნდა კეთდებოდეს ეხლა ეს მეინზე
        //  ეშვება და არ შეიძება მეინ სრედის ბლოკავს
        //  გაარკვიე რა არის დისპაჩერი რა ტიპის დისპაჩერები არსებობს და როდის რომელი უნდა გამოიყენო
        //
        return try{
            api.getUserByName(userLogin).toUserDetail()
        }catch (e: HttpException){
            throw Exception(e.localizedMessage ?: "An unexpected error occurred")
        }catch (e: IOException){
            throw Exception("Couldn't reach server. Check your internet connection.")
        }
    }


}