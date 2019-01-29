package com.mif50.madarsoftkotlin.ui.main

import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import com.mif50.madarsoftkotlin.ui.base.mvvm.MvvmNavigator


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
interface MainNavigator : MvvmNavigator {
    fun setListLocation(locations: List<LocationAddress>)
}