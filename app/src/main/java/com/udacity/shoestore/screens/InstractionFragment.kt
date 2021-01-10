package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstractionBinding

class InstractionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding: FragmentInstractionBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_instraction, container, false)
        dataBinding.getItBtn.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_instractionFragment_to_shoeFragment)
        }
        return dataBinding.root
    }


}