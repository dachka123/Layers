package com.example.layers.di

import com.example.layers.common.Constants
import com.example.layers.data.remote.UserApi
import com.example.layers.data.repository.UserRepositoryImpl
import com.example.layers.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// FIXME: ზოგადად di ფექიჯი როგორც წესი data ლეიერს ეკუთვნის, თუმცა როგორც გაქვს ეგეც არაა შეცდომა

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    // FIXME: აქ პროვაიდი უნდა კი მაგრამ ცალკე უნდა გქონდეს რეტროფიტის პროვაიდი
    //  და ცალკე სერვისის პროვაიდი ერთიდაიგივე ფაილში შეიძლება
    //  იმიტო რო სხვა სერვისიც რო გქონდეს იმასთან უკვე არსებულ რეტროფიტს გამოიყენებ
    //  და ახალი არ შეიქმნება ასე როგორც გიწერია სხვა სერვისის დამატება რო მოგიწიოს
    //  თავიდან უნდა გაწერო ბეიზ url და კონვერტერ ფაქტორი და ა.შ.
    @Provides
    @Singleton
    fun provideUserApi(): UserApi{
        return Retrofit.Builder()
            // FIXME: ბეიზ url ზოგადად buildConfig_ ში უნდა გქონდეს და იქიდან ამოიღო
            //  გაარკვიე ზოგადად რა არის ბილდკონფიგი და როგორ უნდა გამოიყენება
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }

    // FIXME: რეპოზიტორის პრვაიდისთვის ცალკე repository module შექმენი და provide არ გამოიყენო არსებობს
    //  ანოტაცია bind გაარკვიე როდის უნდა გამოიყენო bind და როდის პროვაიდი
    @Provides
    @Singleton
    fun provideUserRepository(api:UserApi): UserRepository{
        return UserRepositoryImpl(api)
    }

    // FIXME: დეფენდენსებში დამატებული გაქვს ლოგინგ ინტერსეპტორი და არსად იყენებ დაგუგლე რა
    //  არის და როგორ გამოიყენება ისიც გაითვალისწინე რო ლოგირება რილიზ ბილდზე არ უნდა ხდებოდეს
}