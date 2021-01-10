package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        dataBinding.addBtn.setOnClickListener { view: View ->

            val shoe = dataBinding.shoe

            viewModel.addShoe(shoe)
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeDetailFragment_to_shoeFragment)

        }
        dataBinding.cancelBtn.setOnClickListener { view: View ->
            Navigation.findNavController(view)
                .navigate(R.id.action_shoeDetailFragment_to_shoeFragment)
        }
        return dataBinding.root
    }
}