package com.example.unnamedgroup12project.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unnamedgroup12project.R
import com.example.unnamedgroup12project.adapters.FeaturedMarketListingAdapter
import com.example.unnamedgroup12project.adapters.MarketListingAdapter
import com.example.unnamedgroup12project.database.MarketFetcher
import com.example.unnamedgroup12project.objects.Market

class MarketListingFragment : Fragment() {
    private lateinit var featuredMarketListingAdapter : FeaturedMarketListingAdapter
    private lateinit var allMarketListingAdapter: MarketListingAdapter
    private val marketList = arrayListOf<Market>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("loaded market listing fragment")
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_market_listing, container, false)
        val featuredMarketListlayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val featuredMarketListRecyclerView = view.findViewById<RecyclerView>(R.id.featuredMarketsRecyclerView)

        // adding starter list twice just to display more items
        marketList.addAll(MarketFetcher.getItems())
        marketList.addAll(MarketFetcher.getItems())

        // The first four markets are featured for now
        featuredMarketListingAdapter = FeaturedMarketListingAdapter(marketList.subList(0, 3))

        featuredMarketListRecyclerView.adapter = featuredMarketListingAdapter
        featuredMarketListRecyclerView.layoutManager = featuredMarketListlayoutManager

        val allMarketListLayoutManager = LinearLayoutManager(context)
        val allMarketListRecyclerView = view.findViewById<RecyclerView>(R.id.allMarketsRecyclerView)
        allMarketListingAdapter = MarketListingAdapter(marketList)

        allMarketListRecyclerView.adapter = allMarketListingAdapter
        allMarketListRecyclerView.layoutManager = allMarketListLayoutManager


        return view
    }


    companion object {
        fun newInstance(): MarketListingFragment {
            return MarketListingFragment()
        }
    }
}