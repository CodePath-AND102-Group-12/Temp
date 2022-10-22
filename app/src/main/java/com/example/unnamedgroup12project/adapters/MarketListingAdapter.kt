package com.example.unnamedgroup12project.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.unnamedgroup12project.Communicator
import com.example.unnamedgroup12project.R
import com.example.unnamedgroup12project.objects.Market

private lateinit var allMarketsRVLayout: CardView
private lateinit var  marketName: TextView
private lateinit var  marketCategory: TextView
private lateinit var marketImage: ImageView

class MarketListingAdapter(private val marketList: MutableList<Market>, private val context: Context, private val activity: AppCompatActivity, private val comm: Communicator): RecyclerView.Adapter<MarketListingAdapter.ViewHolder>() {

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
            marketImage = itemView.findViewById(R.id.marketImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val  contactView = inflater.inflate(R.layout.market_layout, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val market = marketList[position]

        marketName.text = market.name
        marketCategory.text = market.category

        // This should be replaced by whatever the actual image URL is instead of these generic images
        when (market.image) {
            "produce" -> marketImage.setImageResource(R.drawable.produce)
            "bakery" -> marketImage.setImageResource(R.drawable.bakery)
            "fruits" -> marketImage.setImageResource(R.drawable.fruits)
            "plants" -> marketImage.setImageResource(R.drawable.plants)
        }

        allMarketsRVLayout.setOnClickListener {
            Toast.makeText(it.context, "${market.name} clicked", Toast.LENGTH_SHORT).show()

            val newMarket = marketList[holder.layoutPosition]
            val marketArrayList = arrayListOf(newMarket.name, newMarket.address, newMarket.phone, newMarket.category, newMarket.image)

            // communicator to carry information to new fragment
            comm.passDataCom(marketArrayList)

//            val transaction = activity.supportFragmentManager.beginTransaction()
//            val detailFragment = MarketDetailFragment()
//            transaction.replace(R.id.content, detailFragment)
//            transaction.addToBackStack("this fragment")
//            transaction.commit()


        }
    }

    override fun getItemCount(): Int {
        return marketList.size
    }
}