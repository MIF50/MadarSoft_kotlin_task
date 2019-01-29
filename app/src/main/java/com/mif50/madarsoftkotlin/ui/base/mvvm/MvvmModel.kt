package com.mif50.madarsoftkotlin.ui.base.mvvm

import com.mif50.madarsoftkotlin.data.remote.api.model.Model


/**
 * @name time-viewer
 * Copyrights (c) 10/5/18 Created By BeinMedia
 **/
interface MvvmModel<N : MvvmNavigator> {
    fun attachNavigator(navigator: N)
    fun getNavigator(): N
    fun handleError(error: Throwable)
    fun checkStatus(model: Model): Boolean

}