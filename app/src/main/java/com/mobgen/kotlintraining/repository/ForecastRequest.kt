package com.mobgen.kotlintraining.repository

import android.util.Log
import com.google.gson.Gson
import java.net.URL


/**
 * Created by Kiko on 16/01/2018 for KotlinTraining.
 *
 */

class ForecastRequest(val cityId: String) {
    companion object {
        private const val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private const val INCOMPLETE_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private const val COMPLETE_URL = "$INCOMPLETE_URL&APPID=$APP_ID&id="
    }

    fun execute(): ForecastResult {
        val forecastJsonString = URL(COMPLETE_URL + cityId).readText()
        Log.d(javaClass.simpleName, forecastJsonString)
        return Gson().fromJson(forecastJsonString, ForecastResult::class.java)
    }
}