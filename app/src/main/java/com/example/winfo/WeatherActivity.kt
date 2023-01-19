package com.example.winfo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class WeatherActivity : AppCompatActivity() {

    private val weatherPresenter = WeatherPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        tvTemperature.text = weatherPresenter.getWeather(UUID.randomUUID().toString()) //пример перезапуска активити при повороте экрана
    }
}