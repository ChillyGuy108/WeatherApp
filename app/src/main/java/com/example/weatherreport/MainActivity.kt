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
import android.content.Intent




class MainActivity : ComponentActivity() {
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.setOnApplyWindowInsetsListener { view, insets ->
            view.onApplyWindowInsets(insets)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start)
        startButton=findViewById(R.id.button)
        startButton.setOnClickListener {
            lifecycleScope.launch {
                try {
                    val response = WeatherApi.service.getWeather(51.67, 39.18)
                    val weather = response.currentWeather

                    val intent = Intent(this@MainActivity,
                        WeatherActivity::class.java).apply {
                        putExtra("temperature", weather.temperature)
                        putExtra("windSpeed", weather.windSpeed)
                        putExtra("time", weather.time)
                        putExtra("weatherCode", weather.weatherCode)
                    }
                    startActivity(intent)

                } catch (e: Exception) {
                    Log.e("Weather", "Ошибка при получении погоды: ${e.message}", e)
                }

            }

        }

    }
}


