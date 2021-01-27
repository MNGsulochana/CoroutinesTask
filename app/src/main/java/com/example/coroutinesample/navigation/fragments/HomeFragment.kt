package com.example.coroutinesample.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.coroutinesample.R
import com.example.coroutinesample.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home){
   /* // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var signUpButton: Button;
    lateinit var loginButton: Button
*/
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
            navController.navigate(R.id.action_homeFragment_to_loginFragment)
        }


    }


    /*  override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          arguments?.let {
              param1 = it.getString(ARG_PARAM1)
              param2 = it.getString(ARG_PARAM2)
          }
      }


      companion object {
          *//**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         *//*
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }*/
}