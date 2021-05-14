package com.example.nouari3a.presentation.list

import com.example.nouari3a.presentation.api.CovidListResponse

sealed class CovidModel
data class CovidSucess(val covidList : List<CovidListResponse>) : CovidModel()
object CovidLoader: CovidModel()
object CovidError: CovidModel()