package com.example.nouari3a.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nouari3a.presentation.api.CovidListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovidListViewModel: ViewModel(){

    val covidList : MutableLiveData <List<CovidListResponse>> = MutableLiveData()

    init {
        callApi()
    }

    private fun callApi() {
    Singletons.covidApi.getCovidList().enqueue(object : Callback<List<CovidListResponse>> {

        override fun onFailure(call: Call<List<CovidListResponse>>, t: Throwable) {
            TODO("Not yet implemented")
        }

        override fun onResponse(call: Call<List<CovidListResponse>>, response: Response<List<CovidListResponse>>) {
            if (response.isSuccessful && response.body() != null) {
                val covidResponse = response.body()!!
                covidList.value = covidResponse
            }
        }

    })
    }

}