package com.example.tradeonline.ui.main

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tradeonline.R
import com.example.tradeonline.extensions.initStatusBar
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
                R.id.navigation_expert -> {
                    if (currentFragmentIndex == 0) {
                        false
                    } else {
                        currentFragmentIndex = 0
                        navController.navigate(R.id.navigation_expert)
                        true
                    }
                }
                R.id.navigation_journal -> {
                    if (currentFragmentIndex == 1) {
                        false
                    } else {
                        currentFragmentIndex = 1
                        navController.navigate(R.id.navigation_journal)
                        true
                    }
                }
                R.id.navigation_indicator -> {
                    if (currentFragmentIndex == 2) {
                        false
                    } else {
                        currentFragmentIndex = 2
                        navController.navigate(R.id.navigation_indicator)
                        true
                    }
                }
                R.id.navigation_technical_analysis -> {
                    if (currentFragmentIndex == 3) {
                        false
                    } else {
                        currentFragmentIndex = 3
                        navController.navigate(R.id.navigation_technical_analysis)
                        true
                    }
                }
                else -> false
            }

        }
    }

    fun showBottomNavigationView() {
        isHideNavigate = false
        navView.visibility = View.VISIBLE
    }

    fun hideBottomNavigationView() {
        isHideNavigate = true
        navView.visibility = View.GONE
    }

    private fun listenForNavigationDestinationChanges() {
        navController.addOnDestinationChangedListener { _, destination, arguments ->
            when (destination.id) {
                R.id.splashFragment, R.id.asset, R.id.expertDetail -> {
                    hideBottomNavigationView()
                }
                else -> {
                    showBottomNavigationView()

                }
            }
            /*  if (destination.id != R.id.splashFragment)
                  showBottomNavigationView()
              else
                  hideBottomNavigationView()*/
        }
    }

    companion object {
        var remoteCounter = 10
        var pageCounter = 0
    }
}