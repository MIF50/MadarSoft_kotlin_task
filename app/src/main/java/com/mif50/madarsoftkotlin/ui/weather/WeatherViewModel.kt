package com.mif50.madarsoftkotlin.ui.weather

import com.mif50.madarsoftkotlin.app.helper.rx.SchedulerProvider
import com.mif50.madarsoftkotlin.data.DataManager
import com.mif50.madarsoftkotlin.data.remote.api.model.RequestPlace
import com.mif50.madarsoftkotlin.ui.base.mvvm.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

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

