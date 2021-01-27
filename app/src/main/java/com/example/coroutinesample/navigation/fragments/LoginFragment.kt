package com.example.coroutinesample.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.coroutinesample.R
import com.example.coroutinesample.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {

    lateinit var loginBinding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController=Navigation.findNavController(view)
        loginBinding= FragmentLoginBinding.bind(view)
        loginBinding.loginButons.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

    }

}