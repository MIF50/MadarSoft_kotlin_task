package com.mif50.madarsoftkotlin.ui.base.mvvm

import com.mif50.madarsoftkotlin.data.remote.api.model.Model

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
interface MvvmModel<N : MvvmNavigator> {
    fun attachNavigator(navigator: N)
    fun getNavigator(): N
    fun handleError(error: Throwable)
    fun checkStatus(model: Model): Boolean

}