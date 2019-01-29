package com.mif50.madarsoftkotlin.ui.location

import com.mif50.madarsoftkotlin.app.helper.rx.SchedulerProvider
import com.mif50.madarsoftkotlin.data.DataManager
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import com.mif50.madarsoftkotlin.ui.base.mvvm.BaseViewModel
import io.reactivex.disposables.CompositeDisposable


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
class AddCityViewModel<V : AddCityNavigator>(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable
) : BaseViewModel<V>(dataManager, schedulerProvider, compositeDisposable) {

    fun addLocation(location: LocationAddress) {
        dataManager.insertLocation(location)
        getNavigator().numberLocationAdded()
    }
}