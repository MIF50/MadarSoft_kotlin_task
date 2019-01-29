package com.mif50.madarsoftkotlin.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mif50.madarsoftkotlin.R
import com.mif50.madarsoftkotlin.app.extensions.startActivity
import com.mif50.madarsoftkotlin.app.helper.ui.LayoutRes
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import com.mif50.madarsoftkotlin.ui.base.ui.BaseActivity
import com.mif50.madarsoftkotlin.ui.location.AddCityActivity
import com.mif50.madarsoftkotlin.ui.main.item.ItemLocation
import com.mif50.madarsoftkotlin.ui.weather.WeatherActivity
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.OnClickListener
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
@LayoutRes(R.layout.activity_main)
class MainActivity : BaseActivity(), View.OnClickListener, MainNavigator, OnClickListener<IItem<*, *>> {


    private val mainViewModel: MainViewModel<MainNavigator> by viewModel()

    private val fastItemAdapter = FastItemAdapter<IItem<*, *>>()


    override fun bindView(savedInstanceState: Bundle?) {
        initViewModel()
        initAdapter()
        setListener()
    }

    private fun initViewModel() {
        mainViewModel.attachNavigator(this)
        mainViewModel.getLocations()
    }

    private fun initAdapter() {
        locationRv.apply {
            adapter = fastItemAdapter.withOnClickListener(this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }


    private fun setListener() {
        addCityFab.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            addCityFab.id -> startActivity(AddCityActivity.getStartIntent(this))
        }
    }

    override fun setListLocation(locations: List<LocationAddress>) {
        if (locations.count() < 1) {
            noLocationTv.visibility = View.VISIBLE
            return
        }
        locations.map {
            fastItemAdapter.add(ItemLocation().withItem(it))
        }

    }

    override fun onClick(v: View?, adapter: IAdapter<IItem<*, *>>, item: IItem<*, *>, position: Int): Boolean {
        when (item) {
            is ItemLocation -> {
                startActivity<WeatherActivity>(WeatherActivity.getStartIntent(item.location))
            }
        }
        return true
    }
}
