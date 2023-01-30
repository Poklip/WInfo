package com.example.winfo.feature.weather_screen.data

import com.example.winfo.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherApiClient {
    private val okHttpClient = OkHttpClient.Builder()
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) //конвертер для респонса в интерфейсе, чтобы он мог выдать строку, я хз
        .client(okHttpClient)
        .build()

    private val weatherApi = retrofit.create(WeatherApi::class.java)
    fun getApi(): WeatherApi {
        return weatherApi
    }
}