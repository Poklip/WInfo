package com.example.winfo
//MAIN SCREEN
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
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


        val textViewIsAlive = findViewById<TextView>(R.id.textViewIsAlive)
        textViewIsAlive.text = "Lalalalalala."

        val textViewIsDead = findViewById<TextView>(R.id.textViewIsDead)
        textViewIsDead.text = "Have a nice day."

        val buttonToWeatherScreen = findViewById<Button>(R.id.btnWeather)
        buttonToWeatherScreen.setOnClickListener {
            val intent = Intent(this, WeatherActivity::class.java).also { startActivity(it) }
        }

    }
}