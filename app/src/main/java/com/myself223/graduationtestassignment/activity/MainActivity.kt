package com.myself223.graduationtestassignment.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.myself223.graduationtestassignment.R
import com.myself223.graduationtestassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_controller) as NavHostFragment
        val navController = navHostFragment.navController

        // Initialize MainFlowFragment
        if (savedInstanceState == null) {
            navController.navigate(R.id.mainFlowFragment)
        }
    }
}
