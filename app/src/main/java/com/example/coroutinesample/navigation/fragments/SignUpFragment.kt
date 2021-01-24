package com.example.coroutinesample.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.coroutinesample.R

class SignUpFragment : Fragment() {


    lateinit var loginButton:Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton=view.findViewById(R.id.loginButtons)
        var navController=Navigation.findNavController(view)
        loginButton.setOnClickListener {
            navController.navigate(R.id.action_signUpFragment_to_loginFragment)
        }
    }


}