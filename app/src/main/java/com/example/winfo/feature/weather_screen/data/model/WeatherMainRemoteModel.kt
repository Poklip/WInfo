package com.example.winfo.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherMainRemoteModel(
    @SerializedName("temp")
    val temperature: String,
    @SerializedName("humidity")
    val humidity: String
)