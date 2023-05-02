package com.example.winfo.feature.weather_screen.data

import com.example.winfo.feature.weather_screen.ui.model.WeatherModel

//pattern repository - this pattern is used in many cases, it means that "program" takes the newest data from network or from any database

interface WeatherRepo {
    suspend fun getWeather(): WeatherModel
}