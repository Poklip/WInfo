package com.example.winfo.feature.weather_screen.data

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {
    override suspend fun getTemperature(): String {
        return weatherRemoteSource.getWeather().mainWeather.temperature
    }

    override suspend fun getHumidity(): String {
        return weatherRemoteSource.getWeather().mainWeather.humidity
    }

    override suspend fun getWindDegree(): String {
        return weatherRemoteSource.getWeather().windInfo.windDegree
    }
}