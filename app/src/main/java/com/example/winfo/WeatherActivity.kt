package com.example.winfo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

fun temperatureGenerator(): Int {
    var currentTempC = Random.nextInt(-30, 31)
    return currentTempC
}
class WeatherActivity : AppCompatActivity() {

    private val weatherPresenter = WeatherPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        tvTemperature.text =
            weatherPresenter.getWeather(temperatureGenerator()) //пример перезапуска активити при повороте экрана

        val btnBack = findViewById<Button>(R.id.btnToMain)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).also { startActivity(it) }
        }
    }
}