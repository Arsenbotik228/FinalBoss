package com.myself223.graduationtestassignment.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.firebase.messaging.FirebaseMessaging
import com.myself223.graduationtestassignment.R
import com.myself223.graduationtestassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val navController: NavController by lazy {
        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_graph) as NavHostFragment
        navHostFragment.navController
    }
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        FirebaseMessaging.getInstance().subscribeToTopic("all")
            .addOnCompleteListener{}
        handleNotificationData(intent.extras)

    }
    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleNotificationData(intent.extras)
    }


    private fun handleNotificationData(extras: Bundle?) {
        extras?.let {
            val notificationData = it.getString("key")
        }
    }
}
