package com.example.winfo.feature.weather_screen.data

enum class CurrentDirection(val direction: String) {
    North("North"),
    NorthEast("North-East"),
    East("East"),
    SouthEast("SouthEast"),
    South("South"),
    SouthWest("SouthWest"),
    West("West"),
    NorthWest("NorthWest")

}

class WindDirection {
    fun getDirection(degree: Int): String {
        val direction: String = when (degree) {
            in 23..67 -> CurrentDirection.NorthEast.direction
            in 68..102 -> CurrentDirection.East.direction
            in 103..147 -> CurrentDirection.SouthEast.direction
            in 148..202 -> CurrentDirection.South.direction
            in 203..247 -> CurrentDirection.SouthWest.direction
            in 248..292 -> CurrentDirection.West.direction
            in 293..337 -> CurrentDirection.NorthWest.direction
            else -> CurrentDirection.North.direction
        }
        return direction
    }
}