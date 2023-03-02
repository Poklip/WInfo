package com.example.winfo.feature.weather_screen.data

import com.example.winfo.feature.weather_screen.data.model.WeatherRemoteModel
import com.example.winfo.feature.weather_screen.ui.model.WeatherModel

fun WeatherRemoteModel.toDomain() = WeatherModel(
    temperature = this.mainWeather.temperature,
    humidity = this.mainWeather.humidity,
    windDirection = this.windInfo.windDegree
)