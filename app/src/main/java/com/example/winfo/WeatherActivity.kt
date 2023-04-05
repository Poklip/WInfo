package com.example.winfo
//SECOND SCREEN WITH WEATHER INFO
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.winfo.feature.weather_screen.data.WindDirection
import com.example.winfo.feature.weather_screen.ui.UiEvent
import com.example.winfo.feature.weather_screen.ui.ViewState
import com.example.winfo.feature.weather_screen.ui.WeatherScreenViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt

class WeatherActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()
    private val tvWeather: TextView by lazy { findViewById(R.id.tvTemperature) }
    private val btnBack: Button by lazy { findViewById(R.id.btnToMain) }
    private val fabShowWeather: FloatingActionButton by lazy { findViewById(R.id.fabShowWeather) }
    private val progressBar: ProgressBar by lazy { findViewById(R.id.ProgressBar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)


        fabShowWeather.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }

        viewModel.viewState.observe(this, ::render) //link to function

        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).also { startActivity(it) }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun render(viewState: ViewState) {
        progressBar.isVisible = viewState.isLoading
        tvWeather.isVisible = viewState.isInfoVisible
        tvWeather.text =
            "${currentCity}: ${viewState.temperature.toDouble().roundToInt() - 273} C.\n" +
                    "Humidity: ${viewState.humidity} %.\n" +
                    "  Wind is coming from ${WindDirection().getDirection(viewState.windDirection.toInt())}.  "
    }
}