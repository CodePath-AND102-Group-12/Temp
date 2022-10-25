package com.example.unnamedgroup12project.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unnamedgroup12project.Communicator
import com.example.unnamedgroup12project.ProjectViewModel
import com.example.unnamedgroup12project.R
import com.example.unnamedgroup12project.adapters.FeaturedMarketListingAdapter
import com.example.unnamedgroup12project.adapters.MarketListingAdapter
import com.example.unnamedgroup12project.database.MarketFetcher
import com.example.unnamedgroup12project.objects.Market

class MarketListingFragment : Fragment(), MarketListingAdapter.ClickListener {
    private lateinit var featuredMarketListingAdapter : FeaturedMarketListingAdapter
    private lateinit var allMarketListingAdapter: MarketListingAdapter
    private val marketList = arrayListOf<Market>()
    //private lateinit var comm: Communicator

    private val viewModel: ProjectViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("loaded market listing fragment")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_market_listing, container, false)
        val featuredMarketListLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val featuredMarketListRecyclerView = view.findViewById<RecyclerView>(R.id.featuredMarketsRecyclerView)

        // adding starter list twice just to display more items
        marketList.addAll(MarketFetcher.getItems())
        marketList.addAll(MarketFetcher.getItems())

        // The first four markets are featured for now
        featuredMarketListingAdapter = FeaturedMarketListingAdapter(marketList.subList(0, 3))

        featuredMarketListRecyclerView.adapter = featuredMarketListingAdapter
        featuredMarketListRecyclerView.layoutManager = featuredMarketListLayoutManager

        val allMarketListLayoutManager = GridLayoutManager(context, 2)
        val allMarketListRecyclerView = view.findViewById<RecyclerView>(R.id.allMarketsRecyclerView)

        //comm = requireActivity() as Communicator

        allMarketListingAdapter = MarketListingAdapter(marketList,
            requireContext(),
            this
            //,comm
        )

        allMarketListRecyclerView.adapter = allMarketListingAdapter
        allMarketListRecyclerView.layoutManager = allMarketListLayoutManager

        // default spinner code based on official documentation: https://developer.android.com/develop/ui/views/components/spinner
        // will need to later implement an OnItemSelectedListener
        val spinner: Spinner = view.findViewById(R.id.spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        activity?.let {
            ArrayAdapter.createFromResource(
                it.applicationContext,
                R.array.daysOfWeek,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinner.adapter = adapter
            }
        }


        return view
    }


    companion object {
        fun newInstance(): MarketListingFragment {
            return MarketListingFragment()
        }
    }

    override fun gotoMarketDetail(position: Int, marketData: Market) {
        viewModel.setMarketData(marketData)
        val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content, MarketDetailFragment())
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}