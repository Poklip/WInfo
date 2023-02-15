package com.example.winfo
//SECOND SCREEN WITH TEMPERATURE INFO
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.winfo.feature.weather_screen.ui.WeatherScreenViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt

class WeatherActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        var weather = ""
        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)
        var tvHumidity = findViewById<TextView>(R.id.tvHumidity)

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                tvTemperature.text =
                    "${currentCity}: ${viewModel.getTemperature().toDouble().roundToInt() - 273} C."
                tvHumidity.text =
                    "Humidity: ${viewModel.getHumidity()} %."
            }
        }


        val btnBack = findViewById<Button>(R.id.btnToMain)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).also { startActivity(it) }
        }
    }
}