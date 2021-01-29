package com.example.coroutinesample.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavAction
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.coroutinesample.R
import com.example.coroutinesample.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(R.layout.fragment_login) {

    lateinit var loginBinding: FragmentLoginBinding
    lateinit var action: NavAction

    val args:LoginFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var navController=Navigation.findNavController(view)
        loginBinding= FragmentLoginBinding.bind(view)

        if(args.Password.isNullOrEmpty())
        {
            val umailDeeplink=args.umailid
            enterMail.setText("Mail ID:  "+umailDeeplink)
            enterPwd.text="Password : "

        }
        else{
            enterMail.text="Mail ID:  "+args.umailid
            enterPwd.text="Password : "+args.Password
        }

        loginBinding.loginButons.setOnClickListener {
            val action=LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(args.uname.toString())
            navController.navigate(action)
           // navController.navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

    }

}