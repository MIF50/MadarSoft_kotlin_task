package com.mif50.madarsoftkotlin.di

import com.mif50.madarsoftkotlin.app.helper.rx.AppSchedulerProvider
import com.mif50.madarsoftkotlin.app.helper.rx.SchedulerProvider
import com.mif50.madarsoftkotlin.data.DataManager
import com.mif50.madarsoftkotlin.data.DataManagerRepository
import com.mif50.madarsoftkotlin.data.local.db.DbManager
import com.mif50.madarsoftkotlin.data.local.db.DbManagerRepository
import com.mif50.madarsoftkotlin.data.remote.ApiHeader
import com.mif50.madarsoftkotlin.data.remote.ApiManager
import com.mif50.madarsoftkotlin.data.remote.ApiManagerRepository
import com.mif50.madarsoftkotlin.ui.location.AddCityNavigator
import com.mif50.madarsoftkotlin.ui.location.AddCityViewModel
import com.mif50.madarsoftkotlin.ui.main.MainNavigator
import com.mif50.madarsoftkotlin.ui.main.MainViewModel
import com.mif50.madarsoftkotlin.ui.weather.WeatherNavigator
import com.mif50.madarsoftkotlin.ui.weather.WeatherViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
object ApplicationModules {
    val modules = listOf(
        module {

            single<DbManager> { DbManagerRepository(get()) }
            single { ApiHeader() }
            single<ApiManager> { ApiManagerRepository(get()) }
            single<DataManager> { DataManagerRepository(get(), get()) }
            single<SchedulerProvider> { AppSchedulerProvider() }
            single { CompositeDisposable() }
        },
        module {
            viewModel { MainViewModel<MainNavigator>(get(), get(), get()) }
            viewModel { AddCityViewModel<AddCityNavigator>(get(), get(), get()) }
            viewModel { WeatherViewModel<WeatherNavigator>(get(), get(), get()) }
        }

    )
}