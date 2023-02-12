package com.example.winfo
//SECOND SCREEN WITH TEMPERATURE INFO
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.winfo.feature.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import kotlin.math.roundToInt

class WeatherActivity : AppCompatActivity() {

    private val presenter: WeatherScreenPresenter by inject()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        var weather = ""
        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                tvTemperature.text =
                    "${currentCity}: ${presenter.getWeather().toDouble().roundToInt() - 273} C"
            }
        }

        val btnBack = findViewById<Button>(R.id.btnToMain)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).also { startActivity(it) }
        }
    }
}