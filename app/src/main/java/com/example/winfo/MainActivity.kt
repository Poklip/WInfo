package com.example.winfo
//MAIN SCREEN
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.winfo.feature.weather_screen.data.WindDirection
import com.example.winfo.feature.weather_screen.ui.UiEvent
import com.example.winfo.feature.weather_screen.ui.ViewState
import com.example.winfo.feature.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()
    private val tvWeather: TextView by lazy { findViewById(R.id.tvTemperature) }
    private val fabShowWeather: FloatingActionButton by lazy { findViewById(R.id.fabShowWeather) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.ProgressBar) }
    private val citiesSpinner: Spinner by lazy { findViewById(R.id.citiesSpinner) }
    private val costyl = "    \n    "


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.viewState.observe(this, ::render) //link to function

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citiesSpinner.adapter = adapter

        fabShowWeather.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }

        citiesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.processUiEvent(UiEvent.OnCityClicked(citiesSpinner.selectedItem.toString()))
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun render(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        tvWeather.isVisible = viewState.isInfoVisible
        tvWeather.text =
            "${costyl}${currentCity}:${costyl}${costyl}Temperature: ${
                viewState.temperature.toDouble().roundToInt() - 273
            } C.${costyl}Humidity: ${viewState.humidity} %.${costyl}Wind direction: ${
                WindDirection().getDirection(
                    viewState.windDirection.toInt()
                )
            }.${costyl}"
    }
}