package com.example.winfo.feature.weather_screen.data

import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherApi) {


    //TODO add query
    fun getWeather(): Response<String> {
        return api.getWeather(query = "Moscow")
    }
}