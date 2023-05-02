package com.example.winfo.feature.weather_screen

import com.example.winfo.base.Either
import com.example.winfo.base.attempt
import com.example.winfo.feature.weather_screen.data.WeatherRepo
import com.example.winfo.feature.weather_screen.ui.model.WeatherModel

//Класс, который будет собирать информацию из репозитория WeatherRepo и передавать информацию в WeatherRepresenter.

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(): Either<Throwable, WeatherModel> {
        return attempt { weatherRepo.getWeather() }
    }

}