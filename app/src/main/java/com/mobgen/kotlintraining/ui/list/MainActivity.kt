package com.mobgen.kotlintraining.ui.list

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.mobgen.kotlintraining.R
import com.mobgen.kotlintraining.base.BaseActivity
import com.mobgen.kotlintraining.repository.ForecastRequest
import org.jetbrains.anko.alert
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : BaseActivity() {
    companion object {
        private val CORUNA_ID = "3119841"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList: RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        alert ("Show simple alert", "Alert") {
            positiveButton("Ok") {
                toast("Downloading weather data")
            }
        }
        doAsync {
            val result = ForecastRequest(CORUNA_ID).execute()
            uiThread { forecastList.adapter = ForecastListAdapter(result)  }
        }
    }
}