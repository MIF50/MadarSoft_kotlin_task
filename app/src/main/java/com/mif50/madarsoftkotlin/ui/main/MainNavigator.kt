package com.mif50.madarsoftkotlin.ui.main

import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import com.mif50.madarsoftkotlin.ui.base.mvvm.MvvmNavigator

interface MainNavigator : MvvmNavigator {
    fun setListLocation(locations: List<LocationAddress>)
}