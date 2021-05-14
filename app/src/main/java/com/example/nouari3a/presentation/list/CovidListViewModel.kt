package com.example.nouari3a.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nouari3a.presentation.api.CovidListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidListViewModel: ViewModel(){

    val covidList : MutableLiveData <CovidModel> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
        covidList.value = CovidLoader
    Singletons.covidApi.getCovidList().enqueue(object : Callback<List<CovidListResponse>> {

        override fun onFailure(call: Call<List<CovidListResponse>>, t: Throwable) {

            covidList.value = CovidError
        }

        override fun onResponse(call: Call<List<CovidListResponse>>, response: Response<List<CovidListResponse>>) {
            if (response.isSuccessful && response.body() != null) {
                val covidResponse = response.body()!!
                covidList.value = CovidSucess (covidResponse)
            }else {
                covidList.value = CovidError
            }
        }

    })
    }

}