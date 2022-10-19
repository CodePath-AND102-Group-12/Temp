package com.example.unnamedgroup12project.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.example.unnamedgroup12project.ProjectViewModel
import com.example.unnamedgroup12project.R
import com.example.unnamedgroup12project.fragments.MapFragment
import com.example.unnamedgroup12project.fragments.MarketListingFragment
import com.example.unnamedgroup12project.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** ViewModel **/
        val viewModel: ProjectViewModel by viewModels()

        /** Navigation **/
        val nav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                (R.id.action_goto_markets) -> {
                    val supportFragmentManager = supportFragmentManager
                    supportFragmentManager.commit {
                        //TODO: Implement animations here!
                        //setCustomAnimations(
                        //    R.anim.fade_in,
                        //   R.anim.slide_out
                        //)
                        replace(R.id.content, MarketListingFragment())
                        addToBackStack(null)
                    }
                    true

                }

                (R.id.action_goto_map) -> {
                    val supportFragmentManager = supportFragmentManager
                    supportFragmentManager.commit {
                        //TODO: Implement animations here!
                        //setCustomAnimations(
                        //    R.anim.fade_in,
                        //   R.anim.slide_out
                        //)
                        replace(R.id.content, MapFragment())
                        addToBackStack(null)
                    }
                    true
                }
                (R.id.action_goto_settings) -> {
                    val supportFragmentManager = supportFragmentManager
                    supportFragmentManager.commit {
                        //TODO: Implement animations here!
                        //setCustomAnimations(
                        //    R.anim.fade_in,
                        //   R.anim.slide_out
                        //)
                        replace(R.id.content, SettingsFragment())
                        addToBackStack(null)
                    }
                    true
                }
                else ->
                    true
            }
        }
    }
}