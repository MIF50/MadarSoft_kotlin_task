package com.mif50.madarsoftkotlin.ui.base.mvvm

import androidx.annotation.StringRes

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
interface MvvmNavigator {
    fun showLoading()
    fun showError(@StringRes message: Int)
    fun showError(message: String)
    fun showMessage(@StringRes message: Int)
    fun showMessage(message: String)
}