package com.example.winfo.feature.weather_screen.ui

import androidx.lifecycle.ViewModel
import com.example.winfo.feature.weather_screen.WeatherInteractor

class WeatherScreenViewModel(val interactor: WeatherInteractor) : ViewModel() {

    suspend fun getTemperature(): String = interactor.getTemperature()

    suspend fun getHumidity(): String = interactor.getHumidity()

    suspend fun getWindDegree(): String = interactor.getWindDegree()
}