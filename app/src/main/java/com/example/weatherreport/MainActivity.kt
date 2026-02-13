package com.example.weatherreport


import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherreport.ui.theme.WeatherReportTheme

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor




class MainActivity : ComponentActivity() {
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start)
        enableEdgeToEdge()
        startButton=findViewById(R.id.button)
        startButton.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val response = WeatherApi.service.getWeather(51.67, 39.18)
                    val weather = response.currentWeather

                    if (weather != null) {
                        val temperature = weather.temperature
                        val windSpeed = weather.windSpeed
                        val time = weather.time
                        val weatherCode = weather.weatherCode

                        // Для вывода в Log используйте Log.d
                        Log.d("Weather", "Температура: $temperature")
                        Log.d("Weather", "Скорость ветра: $windSpeed")
                        Log.d("Weather", "Время: $time")
                        Log.d("Weather", "Код погоды: $weatherCode")

                        // Или для вывода в UI
                        runOnUiThread {
                            // Обновление UI элементов
                        }
                    }
                } catch (e: Exception) {
                    Log.e("Weather", "Ошибка при получении погоды: ${e.message}", e)
                }
            }

        }

    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

