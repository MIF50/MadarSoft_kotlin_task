package com.mif50.madarsoftkotlin.ui.base.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.mif50.madarsoftkotlin.app.extensions.getLayoutRes
import com.mif50.madarsoftkotlin.ui.base.mvvm.MvvmNavigator

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
abstract class BaseActivity : AppCompatActivity(), MvvmNavigator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes().layout)
        bindView(savedInstanceState)
    }

    abstract fun bindView(savedInstanceState: Bundle?)


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (getLayoutRes().menu != 0) {
            menuInflater.inflate(getLayoutRes().menu, menu)
            onMenuCreated(menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        onMenuItemClickListener(item, item.itemId)
        return super.onOptionsItemSelected(item)

    }

    open fun onMenuCreated(menu: Menu?) {

    }

    open fun onMenuItemClickListener(item: MenuItem?, id: Int) {

    }

    override fun showLoading() {

    }

    override fun showError(message: Int) {
        if (isDestroyed && isFinishing) return

        showError(getString(message))
    }

    override fun showError(message: String) {
        if (isDestroyed && isFinishing) return

    }

    override fun showMessage(message: Int) {
        if (isDestroyed && isFinishing) return

        showMessage(getString(message))
    }

    override fun showMessage(message: String) {
        if (isDestroyed && isFinishing) return

    }



}