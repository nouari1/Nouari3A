package com.example.nouari3a.presentation.list

    import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nouari3a.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CovidListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CovidAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)
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
            adapter =  this@CovidListFragment.adapter
            layoutManager = this@CovidListFragment.layoutManager
        }
        val CovidList = arrayListOf<Covid>().apply{
            add(Covid("France"))
            add(Covid("Belgique"))
            add(Covid("Allemagne"))
            add(Covid("Espagne"))
        }

    adapter.updateList(CovidList)
}
}