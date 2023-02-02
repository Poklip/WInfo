package com.example.winfo
//MAIN SCREEN
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewIsAlive = findViewById<TextView>(R.id.textViewIsAlive)
        textViewIsAlive.text = "Say no more..."

        val textViewIsDead = findViewById<TextView>(R.id.textViewIsDead)
        textViewIsDead.text = "... I know I'm a god of design."

        val buttonToWeatherScreen = findViewById<Button>(R.id.btnWeather)
        buttonToWeatherScreen.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java).also { startActivity(it) }
        }

    }
}