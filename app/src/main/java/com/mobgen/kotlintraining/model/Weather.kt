package com.mobgen.kotlintraining.model

/**
 * Created by Kiko on 16/01/2018 for KotlinTraining.
 *
 */

data class Weather (val id: Long, val main: String, val description: String, val icon: String) {
    fun getIconUrl() : String {
        return "http://openweathermap.org/img/w/$icon.png"
    }
}