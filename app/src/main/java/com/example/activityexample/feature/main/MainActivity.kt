package com.example.activityexample.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.activityexample.R
import com.example.activityexample.databinding.ActivityMainBinding
import com.example.activityexample.feature.detail.DetailActivity
import com.example.activityexample.model.Person

class MainActivity : AppCompatActivity() {
    private val TAG: String? = MainActivity::class.java.name

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Activity Created")
        setContentView(binding.root)
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        val navController = findNavController(R.id.main_nav_host)
        binding.bnvMain.setupWithNavController(navController)
    }

    override fun onStart() {
        Log.d(TAG, "onStart: Activity Started")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume: Activity on Resume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: Activity Paused")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: Activity Stopped")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: Activity Destroyed")
        super.onDestroy()
    }
}