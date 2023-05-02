package com.example.winfo.feature.weather_screen.data

import com.example.winfo.currentCity
import com.example.winfo.feature.weather_screen.data.model.WeatherRemoteModel

class WeatherRemoteSource(private val api: WeatherApi) {

    //TODO add query
    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(query = currentCity)
    }
}