package com.example.winfo

/*
    Android Lifecycle - общие библиотеки
    Retrofit2 - библиотека для выхода в интернет
    Kotlin Coroutines - синхронизация потоков
 */

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewIsAlive = findViewById<TextView>(R.id.textViewIsAlive)
        textViewIsAlive.text = "I am aliiiive in code!"

        val textViewIsDead = findViewById<TextView>(R.id.textViewIsDead)
        textViewIsDead.text = "It means I am working."

        val sex = "no"
    }
}