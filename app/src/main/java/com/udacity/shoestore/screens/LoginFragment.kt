package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding: LoginFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        dataBinding.signupBtn.setOnClickListener{view:View ->
            Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_welcomeFragment2)
        }
        dataBinding.LogInBtn.setOnClickListener{view:View ->
            Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_welcomeFragment2)
    }
        return dataBinding.root
    }


}