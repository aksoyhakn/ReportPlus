package com.aksoyhakn.reportplus.ui.main

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.extensions.handler
import com.aksoyhakn.reportplus.extensions.initStatusBar
import com.google.android.gms.ads.MobileAds
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navView: BottomNavigationView
    private lateinit var navController: NavController

    var currentFragmentIndex = 0
    var isHideNavigate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_TIME);
        MobileAds.initialize(this)

        navView = findViewById(R.id.nav_view)
        initStatusBar()
        navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
        bottomNavListener()
        listenForNavigationDestinationChanges()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                navController.navigateUp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun bottomNavListener() {
        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_main -> {
                    if (currentFragmentIndex == 0) {
                        false
                    } else {
                        currentFragmentIndex = 0
                        navController.navigate(R.id.navigation_main)
                        true
                    }
                }
                R.id.navigation_search -> {
                    if (currentFragmentIndex == 1) {
                        false
                    } else {
                        currentFragmentIndex = 1
                        navController.navigate(R.id.navigation_search)
                        true
                    }
                }
                R.id.navigation_settings -> {
                    if (currentFragmentIndex == 2) {
                        false
                    } else {
                        currentFragmentIndex = 2
                        navController.navigate(R.id.navigation_settings)
                        true
                    }
                }
                else -> false
            }

        }
    }

    private fun showBottomNavigationView() {
        isHideNavigate = false
        handler(50){
            navView.visibility = View.VISIBLE
        }

    }

    private fun hideBottomNavigationView() {
        isHideNavigate = true
        handler(50){
            navView.visibility = View.GONE
        }
    }

    private fun listenForNavigationDestinationChanges() {
        navController.addOnDestinationChangedListener { _, destination, arguments ->
            when (destination.id) {
                R.id.splashFragment, R.id.onBoardingFragment, R.id.downloadFragment -> {
                    hideBottomNavigationView()
                }
                else -> {
                    showBottomNavigationView()
                }
            }
        }
    }

    companion object {
        var remoteCounter = 10
        var pageCounter = 0
    }
}