package com.example.coroutinesample.navigation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.*
import com.example.coroutinesample.R
import com.example.coroutinesample.databinding.ActivityNavigationBinding
import com.example.coroutinesample.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    private lateinit var  activityNavigationBinding: ActivityNavigationBinding
    lateinit var navController: NavController
    lateinit var actionBarTitle: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityNavigationBinding= ActivityNavigationBinding.inflate(layoutInflater)

        setContentView(activityNavigationBinding.root)
        navController=findNavController(R.id.nav_hostFragment)
       // val navController = findNavController(R.id.nav_hostFragment)
      // val navController = Navigation.findNavController(this, R.id.nav_hostFragment)
     //  actionBarTitle= AppBarConfiguration(setOf(R.id.homeFragment,R.id.signUpFragment,R.id.loginFragment))
       // navController.navigate()
       // setupBottomNavMenu(navController)
        //setupActionBarWithNavController(navController,actionBarTitle)
        setupActionBar(navController)
    }

    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this,navController)

    }
   /* override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(actionBarTitle) ||super.onSupportNavigateUp()
        //return NavigationUI.navigateUp(navActivityLayout,Navigation.findNavController(this,R.id.nav_hostFragment))
    }

*/


}