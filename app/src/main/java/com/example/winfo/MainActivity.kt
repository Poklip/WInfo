package com.example.winfo
//MAIN SCREEN
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import com.example.winfo.feature.weather_screen.data.WindDirection
import com.example.winfo.feature.weather_screen.ui.UiEvent
import com.example.winfo.feature.weather_screen.ui.ViewState
import com.example.winfo.feature.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()
    private val tvWeather: TextView by lazy { findViewById(R.id.tvTemperature) }
    private val fabShowWeather: FloatingActionButton by lazy { findViewById(R.id.fabShowWeather) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.ProgressBar) }
    private val citiesSpinner: Spinner by lazy { findViewById(R.id.citiesSpinner) }
    private val collapsingToolbar: CollapsingToolbarLayout by lazy { findViewById(R.id.collapsingToolbar) }
    private val weatherPreviewImageView: AppCompatImageView by lazy { findViewById(R.id.weatherPreviewImageView) }
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
        when (currentCity) {
            "Moscow" -> weatherPreviewImageView.setImageResource(R.drawable.readsquare)
            "Pretoria" -> weatherPreviewImageView.setImageResource(R.drawable.pretoria)
            "London" -> weatherPreviewImageView.setImageResource(R.drawable.london)
            "Mumbai" -> weatherPreviewImageView.setImageResource(R.drawable.mumbai)
            "Cairo" -> weatherPreviewImageView.setImageResource(R.drawable.cairo)
            "Zelenograd" -> weatherPreviewImageView.setImageResource(R.drawable.zelenograd)
        }
        collapsingToolbar.title = currentCity

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