package com.example.coroutinesample.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.example.coroutinesample.R


class WelcomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

        lateinit var backtrkbutn:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backtrkbutn=view.findViewById(R.id.backtrack)
        var navController=Navigation.findNavController(view)
        backtrkbutn.setOnClickListener {
            var navOptions=NavOptions.Builder().setPopUpTo(R.id.homeFragment,true).build()
            navController.navigate(R.id.action_welcomeFragment_to_homeFragment,null,navOptions)
        }
    }


}