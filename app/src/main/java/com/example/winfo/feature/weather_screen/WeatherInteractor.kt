package com.example.winfo.feature.weather_screen

import com.example.winfo.feature.weather_screen.data.WeatherRepo

//Класс, который будет собирать информацию из репозитория WeatherRepo и передавать информацию в WeatherRepresenter.

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(): String {
        return weatherRepo.getTemperature()
    }
}