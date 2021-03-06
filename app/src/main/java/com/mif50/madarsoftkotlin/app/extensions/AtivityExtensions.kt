package com.mif50.madarsoftkotlin.app.extensions

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.mif50.madarsoftkotlin.app.helper.ui.LayoutRes

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
fun Activity.getLayoutRes(): LayoutRes {
    val annotation = this::class.java.annotations.find { it is LayoutRes } as? LayoutRes
    if (annotation != null) {
        return annotation
    } else {
        throw KotlinNullPointerException("Please add the LayoutRes annotation at the top of the class")
    }
}

inline fun <reified T> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T> Context.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T> FragmentActivity.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T> Activity.startActivity(data: Intent) {
    startActivity(Intent(this, T::class.java).putExtras(data))
}

inline fun <reified T> Context.startActivity(data: Intent) {
    startActivity(Intent(this, T::class.java).putExtras(data))
}