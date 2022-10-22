package com.example.unnamedgroup12project.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.unnamedgroup12project.Communicator
import com.example.unnamedgroup12project.ProjectViewModel
import com.example.unnamedgroup12project.R
import com.example.unnamedgroup12project.databinding.ActivityMainBinding
import com.example.unnamedgroup12project.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), Communicator {
    private lateinit var binding: ActivityMainBinding

    // fragment support, each fragment gets initialized
    private val fragmentManager: FragmentManager = supportFragmentManager
    private val marketListFragment: Fragment = MarketListingFragment()
    private val mapFragment: Fragment = MapFragment()
    private val shoppingListFragment: Fragment = ShoppingListFragment()
    private val calendarFragment: Fragment = CalendarFragment()
    private val settingsFragment: Fragment = SettingsFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val viewRoot = binding.root
        setContentView(viewRoot)

        /** ViewModel **/
        val viewModel: ProjectViewModel by viewModels()

        /** Navigation **/
        val nav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        nav.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_goto_markets -> fragment = marketListFragment
                R.id.action_goto_map -> fragment = mapFragment
                R.id.action_goto_shopping_list -> fragment = shoppingListFragment
                R.id.action_goto_calendar -> fragment = calendarFragment
                R.id.action_goto_settings -> fragment = settingsFragment
            }
            replaceFragment(fragment)
            true
        }

        // set default as Market Listing fragment
        nav.selectedItemId = R.id.action_goto_markets

        // start the Activity on Market Listing fragment
        replaceFragment(marketListFragment)
    }

    // Helper function to clean up fragment changes
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, fragment)
        fragmentTransaction.commit()
    }



    override fun passDataCom(toPass: ArrayList<String>) {
        val bundle = Bundle()
        bundle.putStringArrayList("input_txt", toPass)

        val transaction = this.supportFragmentManager.beginTransaction()
        val frag2 = MarketDetailFragment()
        frag2.arguments = bundle

        transaction.replace(R.id.content, frag2)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}