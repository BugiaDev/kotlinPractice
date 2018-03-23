package com.mobgen.kotlintraining.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.mobgen.kotlintraining.R
import com.mobgen.kotlintraining.model.Forecast
import com.mobgen.kotlintraining.repository.ForecastResult
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by Kiko on 15/01/2018 for KotlinTraining.
 */

class ForecastListAdapter (val items: ForecastResult) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forecast_list_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(items.list[position], items.city.name)
    }

    override fun getItemCount(): Int = items.list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.forecast_image)
        private val cityTextView = view.find<TextView>(R.id.city_text_view)
        private val weatherTextView = view.find<TextView>(R.id.weather_text_view)
        private val temperatureTextView = view.find<TextView>(R.id.temperature_text_view)
        private val dateTextView = view.find<TextView>(R.id.date_text_view)

        fun bindForecast(forecast: Forecast, cityName: String) {
            with(forecast) {
                Picasso.with(itemView.context).load(forecast.weather.get(0).getIconUrl()).into(iconView)
                cityTextView.text = cityName
                weatherTextView.text = forecast.weather.get(0).description
                temperatureTextView.text = forecast.temp.day.toInt().toString().plus("ºC")
                dateTextView.text = forecast.getFormattedDate().toString()
            }
        }
    }
}