package com.example.winfo
//SECOND SCREEN WITH TEMPERATURE INFO
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.winfo.feature.weather_screen.WeatherInteractor
import com.example.winfo.feature.weather_screen.data.WeatherApiClient
import com.example.winfo.feature.weather_screen.data.WeatherRemoteSource
import com.example.winfo.feature.weather_screen.data.WeatherRepoImpl
import com.example.winfo.feature.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherActivity : AppCompatActivity() {

    private lateinit var presenter: WeatherScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        presenter = WeatherScreenPresenter(
            WeatherInteractor(
                WeatherRepoImpl(
                    WeatherRemoteSource(WeatherApiClient.getApi())
                )
            )
        )

        var weather = ""
        val tvTemperature = findViewById<TextView>(R.id.tvTemperature)

        GlobalScope.launch {
            Log.d("NET", presenter.interactor.getWeather()) //ОНО ПОЛУЧАЕТ ДАННЫЕ ИЗ ИНТЕРНЕТА!!!
        }


        val btnBack = findViewById<Button>(R.id.btnToMain)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).also { startActivity(it) }
        }
    }
}