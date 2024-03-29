package com.example.winfo.feature.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.winfo.base.BaseViewModel
import com.example.winfo.base.MyEvent
import com.example.winfo.currentCity
import com.example.winfo.feature.weather_screen.WeatherInteractor
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {
    override fun initialViewState(): ViewState =
        ViewState(
            isInfoVisible = false,
            isLoading = false,
            temperature = "0",
            humidity = "",
            windDirection = "0"
        )

    override fun reduce(event: MyEvent, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(
                                DataEvent.OnWeatherFetchSucceed(
                                    temperature = it.temperature,
                                    humidity = it.humidity,
                                    windDirection = it.windDirection
                                )
                            )
                        }
                    )
                }
                return previousState.copy(isInfoVisible = false, isLoading = true)
            }
            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(
                    isInfoVisible = true,
                    isLoading = false,
                    temperature = event.temperature,
                    humidity = event.humidity,
                    windDirection = event.windDirection
                )
            }
            is UiEvent.OnCityClicked -> {
                currentCity = event.currentCity
                return previousState.copy()
            }


            else -> return null
        }
    }
}