package com.example.winfo.feature.weather_screen.data
//pattern repository - this pattern is used in many cases, it means that "program" takes the newest data from network or from any database

interface WeatherRepo {
    suspend fun getTemperature(): String

    suspend fun getHumidity(): String

    suspend fun getWindDegree(): String
}