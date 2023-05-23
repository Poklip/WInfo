package com.example.winfo

import android.widget.ImageView

val cities = arrayOf("Moscow", "Pretoria", "London", "Mumbai", "Cairo", "Zelenograd", "Arzamas")
var currentCity: String = ""

fun setCityImage(city: String, image: ImageView) {
    when (city) {
        "Moscow" -> image.setImageResource(R.drawable.readsquare)
        "Pretoria" -> image.setImageResource(R.drawable.pretoria)
        "London" -> image.setImageResource(R.drawable.london)
        "Mumbai" -> image.setImageResource(R.drawable.mumbai)
        "Cairo" -> image.setImageResource(R.drawable.cairo)
        "Zelenograd" -> image.setImageResource(R.drawable.zelenograd)
        "Arzamas" -> image.setImageResource(R.drawable.arzamas)
    }
}
