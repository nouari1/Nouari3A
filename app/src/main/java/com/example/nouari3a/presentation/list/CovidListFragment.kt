package com.example.nouari3a.presentation.list

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import androidx.fragment.app.Fragment
    import androidx.navigation.fragment.findNavController
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.nouari3a.R
    import com.example.nouari3a.presentation.api.CovidApi
    import com.example.nouari3a.presentation.api.CovidListResponse
    import retrofit2.Call
    import retrofit2.Callback
    import retrofit2.Response
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory



/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CovidListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CovidAdapter(listOf() , ::onClickedCovid)



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_covid_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.covid_recyclerview)

        recyclerView.apply {
            adapter = this@CovidListFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }



        Singletons.covidApi.getCovidList().enqueue(object : Callback<List<CovidListResponse>> {

            override fun onFailure(call: Call<List<CovidListResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<List<CovidListResponse>>, response: Response<List<CovidListResponse>>) {
                if (response.isSuccessful && response.body() != null) {
                    val covidResponse = response.body()!!
                    adapter.updateList(covidResponse)
                }
            }

        })
    }
    private fun onClickedCovid(covidResponse: CovidListResponse) {
        findNavController().navigate(R.id.navigateToCovidDetailFragment, arguments)
    }
}