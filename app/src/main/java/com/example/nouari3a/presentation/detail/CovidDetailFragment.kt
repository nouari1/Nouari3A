package com.example.nouari3a.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.nouari3a.R
import com.example.nouari3a.presentation.list.CovidDetailResponse
import com.example.nouari3a.presentation.list.Singletons
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CovidDetailFragment : Fragment() {
    private lateinit var textViewName: TextView
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
        callApi()
 //       view.findViewById<Button>(R.id.button_1).setOnClickListener {
   //         findNavController().navigate(R.id.navigateToCovidListFragment)
     //   }

    }

    private fun callApi() {
        Singletons.covidApi.getCovidDetail("France").enqueue(object : Callback<CovidDetailResponse>){
             fun onFailure(
                call : Call<CovidDetailResponse>,
                t: Throwable
            ){

            }
             fun onResponse(
                call :  Call<CovidDetailResponse>,
                response: Response <CovidDetailResponse>
            ){
                 if (response.isSuccessful && response.body() != null) {
                textViewName.text= response.body()!!.Active.toString()
                 }
            }
        }
    }


}

private fun <T> Call<T>.enqueue(callback: Callback<CovidDetailResponse>, function: () -> Unit) {

}


