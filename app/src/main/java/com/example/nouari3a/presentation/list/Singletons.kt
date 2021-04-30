package com.example.nouari3a.presentation.list

import com.example.nouari3a.presentation.api.CovidApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons {
    companion object{
         val covidApi: CovidApi = Retrofit.Builder()
            .baseUrl("https://api.covid19api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CovidApi::class.java)
    }

}

