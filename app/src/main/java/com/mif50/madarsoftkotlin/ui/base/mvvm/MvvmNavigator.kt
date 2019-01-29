package com.mif50.madarsoftkotlin.ui.base.mvvm

import androidx.annotation.StringRes

/**
 * @name time-viewer
 * Copyrights (c) 10/5/18 Created By BeinMedia
 **/
interface MvvmNavigator {
    fun showLoading()
    fun showError(@StringRes message: Int)
    fun showError(message: String)
    fun showMessage(@StringRes message: Int)
    fun showMessage(message: String)
}