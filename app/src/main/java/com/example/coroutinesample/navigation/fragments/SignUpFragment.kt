package com.example.coroutinesample.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.coroutinesample.R
import com.example.coroutinesample.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {


    lateinit var binding: FragmentSignUpBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSignUpBinding.bind(view)
        var navController=Navigation.findNavController(view)


        binding.loginButtons.setOnClickListener {
            val uname=binding.enterName.text.toString()
            val upwd=binding.enterPwd.text.toString()
            val mailid=binding.enterMail.text.toString()
            val action=SignUpFragmentDirections.actionSignUpFragmentToLoginFragment(uname,upwd,mailid)
          //  navController.navigate(R.id.action_signUpFragment_to_loginFragment)
            navController.navigate(action)
        }
    }


}