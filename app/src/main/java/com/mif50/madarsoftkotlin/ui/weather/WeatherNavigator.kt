package com.mif50.madarsoftkotlin.ui.weather

import com.mif50.madarsoftkotlin.data.remote.api.model.Place
import com.mif50.madarsoftkotlin.ui.base.mvvm.MvvmNavigator


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
interface WeatherNavigator : MvvmNavigator {
    fun showWeatherData(weather: Place)
}