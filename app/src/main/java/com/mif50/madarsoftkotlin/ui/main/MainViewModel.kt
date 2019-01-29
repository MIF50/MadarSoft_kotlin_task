package com.mif50.madarsoftkotlin.ui.main

import com.mif50.madarsoftkotlin.app.helper.rx.SchedulerProvider
import com.mif50.madarsoftkotlin.data.DataManager
import com.mif50.madarsoftkotlin.ui.base.mvvm.BaseViewModel
import io.reactivex.disposables.CompositeDisposable


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
class MainViewModel<V : MainNavigator>(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) : BaseViewModel<V>(dataManager, schedulerProvider, compositeDisposable) {


    fun getLocations() {
        compositeDisposable.add(
            dataManager.getAll()
                .compose(schedulerProvider.ioToMainFlowableScheduler())
                .subscribe({
                    getNavigator().setListLocation(it)
                }, {
                    handleError(it)
                })
        )
    }
}