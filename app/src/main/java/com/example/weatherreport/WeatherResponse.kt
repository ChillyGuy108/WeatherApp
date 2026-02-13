package com.example.weatherreport
import com.squareup.moshi.Json

data class WeatherResponse(
    @Json(name = "current_weather")
    val currentWeather: CurrentWeather
)

data class CurrentWeather(
    val temperature: Double,

    @Json(name = "windspeed")  // В JSON от Open-Meteo поле называется "windspeed"
    val windSpeed: Double,

    @Json(name = "weathercode")  // В JSON "weathercode"
    val weatherCode: Int,

    val time: String,

    @Json(name = "winddirection")
    val windDirection: Double? = null,

    @Json(name = "is_day")
    val isDay: Int? = null
)
