package com.example.winfo.feature.weather_screen.data

val directions = arrayOf(
    "North",
    "North-East",
    "East",
    "South-East",
    "South",
    "South-West",
    "West",
    "North-West"
)

class WindDirection {
    fun getDirection(degree: Int): String {
        val direction: String = when (degree) {
            in 23..67 -> directions[1]
            in 68..102 -> directions[2]
            in 103..147 -> directions[3]
            in 148..202 -> directions[4]
            in 203..247 -> directions[5]
            in 248..292 -> directions[6]
            in 293..337 -> directions[7]
            else -> directions[0]
        }
        return direction
    }
}