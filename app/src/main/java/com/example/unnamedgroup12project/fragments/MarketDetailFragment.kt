package com.example.unnamedgroup12project.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.unnamedgroup12project.ProjectViewModel
import com.example.unnamedgroup12project.R
import com.example.unnamedgroup12project.objects.Market

class MarketDetailFragment() : Fragment() {

    //private lateinit var marketDetailDataArray: ArrayList<String>
    private lateinit var marketImage: ImageView
    private lateinit var marketName: TextView
    private lateinit var marketAddress: TextView
    private lateinit var marketCategory: TextView
    private lateinit var marketPhone: TextView

    private val viewModel: ProjectViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_market_detail, container, false)

        marketImage = view.findViewById(R.id.marketImage)
        marketName = view.findViewById(R.id.marketName)
        marketAddress = view.findViewById(R.id.marketAddress)
        marketCategory = view.findViewById(R.id.marketCategory)
        marketPhone = view.findViewById(R.id.marketPhone)

        // recreate array of market data from passed in argument
        //marketDetailDataArray = arguments?.getStringArrayList("input_txt") as ArrayList<String>

        // create market object based on the data array
        val marketDetail = viewModel.market.value

        // use that data to display in the fragment
        marketName.text = marketDetail?.name
        marketAddress.text = marketDetail?.address
        marketCategory.text = marketDetail?.category
        marketPhone.text = marketDetail?.phone

        // This should be replaced by whatever the actual image URL is instead of these generic images
        when (marketDetail?.image) {
            "produce" -> marketImage.setImageResource(R.drawable.produce)
            "bakery" -> marketImage.setImageResource(R.drawable.bakery)
            "fruits" -> marketImage.setImageResource(R.drawable.fruits)
            "plants" -> marketImage.setImageResource(R.drawable.plants)
        }

        return view
    }

}