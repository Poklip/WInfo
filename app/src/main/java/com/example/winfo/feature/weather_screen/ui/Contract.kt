package com.example.winfo.feature.weather_screen.ui

import com.example.winfo.base.MyEvent

data class ViewState(
    val isInfoVisible: Boolean,
    val isLoading: Boolean,
    val temperature: String,
    val humidity: String,
    val windDirection: String
)

sealed class UiEvent : MyEvent {
    object OnButtonClicked : UiEvent()
    data class OnCityClicked(val currentCity: String) : UiEvent()
}

sealed class DataEvent : MyEvent {
    data class OnWeatherFetchSucceed(
        val temperature: String,
        val humidity: String,
        val windDirection: String
    ) : DataEvent()

    data class OnWeatherFetchFailed(val error: Throwable) : DataEvent()
}