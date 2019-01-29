package com.mif50.madarsoftkotlin.ui.weather

import com.mif50.madarsoftkotlin.app.helper.rx.SchedulerProvider
import com.mif50.madarsoftkotlin.data.DataManager
import com.mif50.madarsoftkotlin.data.remote.api.model.RequestPlace
import com.mif50.madarsoftkotlin.ui.base.mvvm.BaseViewModel
import io.reactivex.disposables.CompositeDisposable


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
class WeatherViewModel<V : WeatherNavigator>(
    dataManager: DataManager,
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable
) :
    BaseViewModel<V>(dataManager, schedulerProvider, compositeDisposable) {

    fun callApiGetWeather(requestPlace: RequestPlace) {
        compositeDisposable.add(
            dataManager.getPlaceData(requestPlace)
                .compose(schedulerProvider.ioToMainSingleScheduler())
                .subscribe({

                    getNavigator().showWeatherData(it)

                }, {
                    handleError(it)
                })
        )
    }
}

