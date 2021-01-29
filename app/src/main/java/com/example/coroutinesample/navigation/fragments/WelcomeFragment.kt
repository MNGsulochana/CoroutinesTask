package com.example.coroutinesample.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.coroutinesample.R
import com.example.coroutinesample.databinding.FragmentWelcomeBinding
import kotlinx.android.synthetic.main.fragment_welcome.*


class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

    lateinit var binding: FragmentWelcomeBinding
   val args:WelcomeFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding= FragmentWelcomeBinding.bind(view)
        welcomeText.text="WELCOME TO  "+args.uname
        var navController=Navigation.findNavController(view)
        binding.backtrack.setOnClickListener {
            var navOptions=NavOptions.Builder().setPopUpTo(R.id.homeFragment,true).build()
            navController.navigate(R.id.action_welcomeFragment_to_homeFragment,null,navOptions)
        }
    }


}