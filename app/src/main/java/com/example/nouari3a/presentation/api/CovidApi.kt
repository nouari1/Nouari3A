package com.example.nouari3a.presentation.api

import retrofit2.Call
import retrofit2.http.GET


interface CovidApi {
    @GET("countries")
    fun getCovidList(): Call<List<CovidResponse>>

}