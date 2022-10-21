package com.example.unnamedgroup12project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.unnamedgroup12project.R
import com.example.unnamedgroup12project.objects.Market

private lateinit var allMarketsRVLayout: ConstraintLayout
private lateinit var  marketName: TextView
private lateinit var  marketCategory: TextView

class MarketListingAdapter(private val marketList: MutableList<Market>): RecyclerView.Adapter<MarketListingAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            allMarketsRVLayout = itemView.findViewById(R.id.allMarketsRVLayout)
            marketName = itemView.findViewById(R.id.marketName)
            marketCategory = itemView.findViewById(R.id.marketCategory)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val  contactView = inflater.inflate(R.layout.market_layout, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val market = marketList.get(position)

        marketName.text = market.name
        marketCategory.text = market.category

        allMarketsRVLayout.setOnClickListener {
            Toast.makeText(it.context, "${market.name} clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return marketList.size
    }
}