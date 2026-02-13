package com.example.weatherreport
import retrofit2.http.GET
import retrofit2.http.Query
import android.telecom.Call
interface WeatherApiService {
    @GET("v1/forecast")

     suspend fun getWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
        @Query("current_weather") current: Boolean = true
    ): WeatherResponse

    companion object
}