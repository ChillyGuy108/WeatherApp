package com.example.weatherreport

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import kotlin.apply;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


object WeatherApi {
    val logging = HttpLoggingInterceptor();
    val level=HttpLoggingInterceptor.Level.BODY;


    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())  // ← ОБЯЗАТЕЛЬНО!
        .build()


    val client= OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    val retrofit= Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com/")
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val service: WeatherApiService by lazy{
        retrofit.create(WeatherApiService::class.java)
    }


}