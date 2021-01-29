package com.example.coroutinesample.navigation.fragments

import android.app.PendingIntent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.coroutinesample.CHANNEL_ID
import com.example.coroutinesample.R
import com.example.coroutinesample.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home){

    lateinit var fragmentHomeBinding: FragmentHomeBinding
    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentHomeBinding= FragmentHomeBinding.bind(view)
         navController=Navigation.findNavController(view)



        fragmentHomeBinding.signupButton.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_signUpFragment)
        }
        fragmentHomeBinding.loginButton.setOnClickListener {

            val pendingIntent = findNavController()
                .createDeepLink()
                .setGraph(R.navigation.nav_graph)
                .setDestination(R.id.loginFragment)
                .setArguments(LoginFragmentArgs(umailid = "sulochana@gmail.com").toBundle())
                .createPendingIntent()

            showNotification(pendingIntent)
            //navController.navigate(R.id.action_homeFragment_to_loginFragment)
        }


    }

    private fun showNotification(pendingIntent: PendingIntent) {
        val notification = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_outline_notifications_24)
            .setContentTitle("check deep link")
            .setContentText("Call login  ")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(requireContext()).notify(1002,notification)
    }

}