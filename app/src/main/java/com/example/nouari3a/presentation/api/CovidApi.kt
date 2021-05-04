package com.example.nouari3a.presentation.api

import com.example.nouari3a.presentation.detail.CovidDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CovidApi {
    @GET("countries")
    fun getCovidList(): Call<List<CovidListResponse>>


    @GET("country/{id}")
    fun getCovidDetail(@Path("id") id:Int): Call<List<CovidDetailResponse>>
}

