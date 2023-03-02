package com.example.winfo.feature.weather_screen.data

import com.example.winfo.feature.weather_screen.ui.model.WeatherModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getWeather(): WeatherModel {
        return weatherRemoteSource.getWeather().toDomain()
    }
}