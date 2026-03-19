package com.example.weatherreport

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherreport.ui.theme.WeatherReportTheme
import android.content.Intent
import android.graphics.Color

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class WeatherActivity : ComponentActivity() {
    private lateinit var background: ConstraintLayout

    private lateinit var temperature: TextView
    private lateinit var wind: TextView

    private lateinit var final_weather: TextView

    var popa=intent.getIntExtra("weatherCode", 0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainscreen)
        temperature=findViewById<TextView>(R.id.textView3)
        wind=findViewById<TextView>(R.id.textView5)
        background=findViewById<ConstraintLayout>(R.id.mainscreen)
        final_weather=findViewById<TextView>(R.id.textView6)
        temperature.text="${intent.getDoubleExtra("temperature", 0.0).toString()}°"
        wind.text=intent.getDoubleExtra("windSpeed", 0.0).toString()
        final_weather.text=weatherCodeDecipher()
        updateBackground()
    }

    fun weatherCodeDecipher(): String{
        when(popa){
            0 -> return "Ясное небо"
            1 -> return "Преимущественно ясно"
            2 -> return "Переменная облачность"
            3 -> return "Пасмурно"
            45 -> return "Туман"
            48 -> return "Инейный туман"
            51 -> return "Слабая морось"
            53 -> return "Умеренная морось"
            55 -> return "Сильная морось"
            56 -> return "Слабая ледяная морось"
            57 -> return "Сильная ледяная морось"
            61 -> return "Слабый дождь"
            63 -> return "Умеренный дождь"
            65 -> return "Сильный дождь"
            66 -> return "Слабый дождь со льдом"
            67 -> return "Сильный дождь со льдом"
            71 -> return "Слабый снегопад"
            73 -> return "Умеренный снегопад"
            75 -> return "Сильный снегопад"
            77 -> return "Снежная крупа"
            80 -> return "Слабый ливень"
            81 -> return "Умеренный ливень"
            82 -> return "Сильный ливень"
            85 -> return "Слабый снежный ливень"
            86 -> return "Сильный снежный ливень"
            95 -> return "Гроза"
            96 -> return "Гроза с градом"
            99 -> return "Сильная гроза с градом"
        }
        return "Ошибка"
    }

    fun updateBackground(){
        val color=when(popa){
            0 -> Color.parseColor("#87CEEB")
            1 -> Color.parseColor("#B0C4DE")
            2 -> Color.parseColor("#778899")
            3 -> Color.parseColor("#708090")
            45, 48 -> Color.parseColor("#C0C0C0")
            51, 53, 55, 56, 57 -> Color.parseColor("#A9A9A9")
            61, 63, 65, 66, 67 -> Color.parseColor("#4682B4")
            71, 73, 75, 77 -> Color.parseColor("#FFFFFF")
            80, 81, 82 -> Color.parseColor("#4169E1")
            85, 86 -> Color.parseColor("#F0F8FF")
            95, 96, 99 -> Color.parseColor("#2F4F4F")

            else -> Color.parseColor("#808080")

        }

        background.setBackgroundColor(color)
    }

}


