package com.example.winfo.feature.weather_screen.di

import com.example.winfo.BASE_URL
import com.example.winfo.feature.weather_screen.WeatherInteractor
import com.example.winfo.feature.weather_screen.data.WeatherApi
import com.example.winfo.feature.weather_screen.data.WeatherRemoteSource
import com.example.winfo.feature.weather_screen.data.WeatherRepo
import com.example.winfo.feature.weather_screen.data.WeatherRepoImpl
import com.example.winfo.feature.weather_screen.ui.WeatherScreenPresenter
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {

    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<WeatherApi> { get<Retrofit>().create(WeatherApi::class.java) }

    single { WeatherRemoteSource(get<WeatherApi>()) }

    single<WeatherRepo> { WeatherRepoImpl(get<WeatherRemoteSource>()) }

    single { WeatherInteractor(get<WeatherRepo>()) }

    single { WeatherScreenPresenter(get<WeatherInteractor>()) }

}