package com.mif50.madarsoftkotlin.ui.main

import com.mif50.madarsoftkotlin.app.helper.rx.SchedulerProvider
import com.mif50.madarsoftkotlin.data.DataManager
import com.mif50.madarsoftkotlin.ui.base.mvvm.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

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