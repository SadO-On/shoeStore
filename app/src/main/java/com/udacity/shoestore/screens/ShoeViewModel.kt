package com.udacity.shoestore.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe


class ShoeViewModel : ViewModel() {
    private val _shoeListLiveData = MutableLiveData<MutableList<Shoe>>()
    val shoeListLiveData: LiveData<MutableList<Shoe>>
        get() = _shoeListLiveData


    init {
        _shoeListLiveData.value = mutableListOf<Shoe>(
            Shoe(
                " QT RACER 2 SNEAKER",
                5.5,
                "ADIDAS",
                "The retro style of the adidas stripes branding gets a modern update with this QT Racer 2 sneaker.",
                mutableListOf<String>("https://deichmann.scene7.com/asset/deichmann/US_01_422442_02?\$rr_main\$&defaultImage=default_obs")
            ), Shoe(
                " EL REY SLIP ON SNEAKER",
                6.0,
                "PUMA",
                "The El Rey Slip-On sneaker by Puma is quick, comfortable, and super sleek.",
                mutableListOf<String>("https://deichmann.scene7.com/asset/deichmann/US_01_630289_00?\$rr_main\$&defaultImage=default_obs")
            )
        )
    }

    fun addShoe(shoe: Shoe) {
        _shoeListLiveData.value?.add(shoe)
        _shoeListLiveData.value = _shoeListLiveData.value
    }


}


