package com.mif50.madarsoftkotlin.ui.weather

import com.mif50.madarsoftkotlin.data.remote.api.model.Place
import com.mif50.madarsoftkotlin.ui.base.mvvm.MvvmNavigator

interface WeatherNavigator : MvvmNavigator {
    fun showWeatherData(weather: Place)
}