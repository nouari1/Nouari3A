package com.example.nouari3a.presentation.list

    import android.os.Bundle
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.ProgressBar
    import android.widget.TextView
    import androidx.core.os.bundleOf
    import androidx.core.view.isVisible
    import androidx.fragment.app.Fragment
    import androidx.fragment.app.viewModels
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
    import java.util.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CovidListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CovidAdapter(listOf() , ::onClickedCovid)
    private lateinit var  loader: ProgressBar
    private lateinit var  textViewError: TextView
    private val viewModel: CovidListViewModel by viewModels ()


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
        loader = view.findViewById(R.id.covid_loader)
        textViewError = view.findViewById(R.id.covid_error)
        recyclerView.apply {
            adapter = this@CovidListFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.covidList.observe(viewLifecycleOwner, androidx.lifecycle.Observer { covidModel ->
            loader.isVisible = covidModel is CovidLoader
            textViewError.isVisible = covidModel is CovidError
            if( covidModel is CovidSucess) {
                adapter.updateList(covidModel.covidList)
            }
        })


    }
    private fun onClickedCovid(covidResponse: CovidListResponse) {
        findNavController().navigate(R.id.navigateToCovidDetailFragment, bundleOf(
                "covidId" to covidResponse.Country
        ))
    }
}