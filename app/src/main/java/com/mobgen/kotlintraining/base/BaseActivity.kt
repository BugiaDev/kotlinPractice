package com.mobgen.kotlintraining.base

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by Kiko on 15/01/2018 for KotlinTraining.
 */

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    fun Context.snackBar(message: CharSequence, duration: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(window.decorView.rootView, message, duration).show()
    }
}