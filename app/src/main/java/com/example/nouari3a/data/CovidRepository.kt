package com.example.nouari3a.data

import com.example.nouari3a.presentation.api.CovidListResponse

interface CovidRepository {
    fun getCovidList() : List<CovidListResponse>
}