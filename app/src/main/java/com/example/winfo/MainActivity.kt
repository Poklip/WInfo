package com.example.winfo
//MAIN SCREEN
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.winfo.feature.weather_screen.ui.WeatherScreenViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val citiesSpinner = findViewById<Spinner>(R.id.citiesSpinner)
        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citiesSpinner.adapter = adapter
        citiesSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO()
            }
            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                currentCity = citiesSpinner.selectedItem.toString()
            }
        }

        val buttonToWeatherScreen = findViewById<Button>(R.id.btnWeather)
        buttonToWeatherScreen.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java).also { startActivity(it) }
        }

    }
}