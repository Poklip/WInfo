package com.example.winfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewIsAlive = findViewById<TextView>(R.id.textViewIsAlive)
        textViewIsAlive.text = "I am aliiiive in code!"

        val textViewIsDead = findViewById<TextView>(R.id.textViewIsDead)
        textViewIsDead.text = "It means I am working."
    }
}