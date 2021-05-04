package com.example.nouari3a.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.nouari3a.R
import com.example.nouari3a.presentation.api.CovidListResponse
import com.example.nouari3a.presentation.list.Singletons
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CovidDetailFragment : Fragment() {
    private lateinit var textViewName: TextView
    private lateinit var textViewActive: TextView
    private lateinit var textViewConfirmed: TextView
    private lateinit var textViewDeaths: TextView
    private lateinit var textViewRecovered: TextView
    private lateinit var textViewDate: TextView


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_covid_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewName = view.findViewById(R.id.covid_detail_country);
        textViewActive = view.findViewById(R.id.covid_detail_active);
        textViewConfirmed = view.findViewById(R.id.covid_detail_confirmed);
        textViewDeaths = view.findViewById(R.id.covid_detail_deaths);
        textViewRecovered=view.findViewById(R.id.covid_detail_recovered);
        textViewDate=view.findViewById(R.id.covid_detail_date);
        callApi()
 //       view.findViewById<Button>(R.id.button_1).setOnClickListener {
   //         findNavController().navigate(R.id.navigateToCovidListFragment)
     //   }

    }

    private fun callApi() {
        val id = arguments?.getInt("covidId") ?: -1
        Singletons.covidApi.getCovidDetail(id).enqueue(object : Callback<List<CovidDetailResponse>> {
            override fun onFailure(call: Call<List<CovidDetailResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }
            override fun onResponse(
                call: Call<List<CovidDetailResponse>>,
                response: Response<List<CovidDetailResponse>>
            ) {
                if (response.isSuccessful && response.body() != null){
                    textViewActive.text = "Active : " + response.body()!![0].Active.toString()
                    textViewConfirmed.text = "Confirmed : " + response.body()!![0].Confirmed.toString()
                    textViewDeaths.text = "Deaths : " + response.body()!![0].Deaths.toString()
                    textViewRecovered.text = "Recovered : " + response.body()!![0].Recovered.toString()
                    textViewName.text = "Province : " + response.body()!![0].Province.toString()
                    textViewDate.text = "Date : "+ response.body()!![0].Date.toString()

                }
            }

        })



}}

