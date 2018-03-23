package com.mobgen.kotlintraining.repository

import com.mobgen.kotlintraining.model.City
import com.mobgen.kotlintraining.model.Forecast

/**
 * Created by Kiko on 15/01/2018 for KotlinTraining.
 *
 */

data class ForecastResult(val city: City, val list: List<Forecast>)