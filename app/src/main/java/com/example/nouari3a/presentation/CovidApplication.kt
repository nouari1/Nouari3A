package com.example.nouari3a.presentation

import android.app.Application
import android.content.Context

class CovidApplication : Application(){
    companion object{
        var context: Context?= null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}