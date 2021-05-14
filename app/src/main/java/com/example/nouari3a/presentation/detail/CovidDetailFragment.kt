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
    private lateinit var textViewProvince: TextView
    private lateinit var textViewActive: TextView
    private lateinit var textViewConfirmed: TextView
    private lateinit var textViewDeaths: TextView
    private lateinit var textViewRecovered: TextView
    private lateinit var textViewDate: TextView
    private lateinit var textViewCountryName: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_covid_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewProvince = view.findViewById(R.id.covid_detail_country);
        textViewActive = view.findViewById(R.id.covid_detail_active);
        textViewConfirmed = view.findViewById(R.id.covid_detail_confirmed);
        textViewDeaths = view.findViewById(R.id.covid_detail_deaths);
        textViewRecovered=view.findViewById(R.id.covid_detail_recovered);
        textViewDate=view.findViewById(R.id.covid_detail_date);
        textViewCountryName=view.findViewById(R.id.covid_detail_countryname);
        callApi()
 //       view.findViewById<Button>(R.id.button_1).setOnClickListener {
   //         findNavController().navigate(R.id.navigateToCovidListFragment)
     //   }

    }

    private fun callApi() {
        val id = arguments?.getString("covidId") ?: ""
        Singletons.covidApi.getCovidDetail(id).enqueue(object : Callback<List<CovidDetailResponse>> {
            override fun onFailure(call: Call<List<CovidDetailResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }
            override fun onResponse(
                call: Call<List<CovidDetailResponse>>,
                response: Response<List<CovidDetailResponse>>
            ) {
                if (response.isSuccessful && response.body() != null){
                    textViewCountryName.text = "Pays : " + response.body()!!.last().Country.toString()
                    textViewActive.text = "Active : " + response.body()!!.last().Active.toString()
                    textViewConfirmed.text = "Confirmed : " + response.body()!!.last().Confirmed.toString()
                    textViewDeaths.text = "Deaths : " + response.body()!!.last().Deaths.toString()
                    textViewRecovered.text = "Recovered : " + response.body()!!.last().Recovered.toString()
                    if (response.body()!![300].Province.toString() == ""){
                    }else{
                        textViewProvince.text = "Province : " + response.body()!!.last().Province.toString()
                    }
                    textViewDate.text = "Date : "+ response.body()!!.last().Date.toString()

                }
            }

        })



}}

