package com.example.coroutinesample.navigation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.coroutinesample.R

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
       // val navController = Navigation.findNavController(this, R.id.nav_hostFragment)
       // navController.navigate()


    }
}