package com.mobgen.kotlintraining.model

import java.util.*

/**
 * Created by Kiko on 15/01/2018 for KotlinTraining.
 *
 */

data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int, val weather: List<Weather>, val speed: Float,
                    val deg: Int, val clouds: Int, val rain: Float) {
    fun getFormattedDate() : Date {
        // Unix timestamp is in seconds. I need to multiply by 1000 to get millis...
        return Date(dt * 1000)
    }
}