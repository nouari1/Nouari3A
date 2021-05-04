package com.example.nouari3a.presentation.detail

data class CovidDetailResponse (
       // val countries: List<CovidCountry>,
      //  val country:String
        val Confirmed: Int,
        val Deaths: Int,
        val Recovered: Int,
        val Active: Int,
        val Province: String,
        val Date: String,
        val TotalConfirmed: Int
)
/*
data class CovidCountry (
    val Confirmed: Int,
    val Deaths: Int,
    val Recovered: Int,
    val Active: Int
)
*/