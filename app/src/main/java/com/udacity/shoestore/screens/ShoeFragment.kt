package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.databinding.ItemRowBinding

class ShoeFragment : Fragment() {
  private  val viewModel : ShoeViewModel by activityViewModels()
  private lateinit var dataBinding :FragmentShoeBinding
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
     dataBinding =
      DataBindingUtil.inflate(inflater, R.layout.fragment_shoe, container, false)


    viewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { newShoeList ->
      for(shoe in newShoeList){
        val shoeItem = ItemRowBinding.inflate(layoutInflater,null,false)
        shoeItem.shoe=shoe
        dataBinding.linearLayout.addView(shoeItem.root)
      }

    })
    dataBinding.fab.setOnClickListener { view:View ->
      Navigation.findNavController(view).navigate(R.id.action_shoeFragment_to_shoeDetailFragment)
    }
    setHasOptionsMenu(true)
    return dataBinding.root
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    super.onCreateOptionsMenu(menu, inflater)
    inflater.inflate(R.menu.overflow_menue, menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())||
    super.onOptionsItemSelected(item)
  }
}