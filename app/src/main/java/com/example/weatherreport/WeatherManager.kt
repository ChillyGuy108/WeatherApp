package com.example.weatherreport

class WeatherManager {
    private var _currentWeather: CurrentWeather? = null
    val currentWeather: CurrentWeather?
        get() = _currentWeather

    suspend fun fetchWeather(lat: Double, lon: Double): Result<CurrentWeather> {
        return try {
            val response = WeatherApi.service.getWeather(lat, lon)
            _currentWeather = response.currentWeather
            Result.success(_currentWeather!!)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}