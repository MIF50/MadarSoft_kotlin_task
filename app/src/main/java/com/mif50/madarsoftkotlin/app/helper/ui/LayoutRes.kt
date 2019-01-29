package com.mif50.madarsoftkotlin.app.helper.ui

/**
 * @name Time viewer
 * Copyrights (c) 9/28/18 Created By BeinMedia
 **/
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class LayoutRes(val layout: Int = 0, val menu: Int = 0, val withBack: Boolean = false)
