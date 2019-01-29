package com.mif50.madarsoftkotlin.ui.weather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mif50.madarsoftkotlin.R
import com.mif50.madarsoftkotlin.app.helper.ui.LayoutRes
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import com.mif50.madarsoftkotlin.data.remote.api.model.Place
import com.mif50.madarsoftkotlin.data.remote.retrofit.ApiServices
import com.mif50.madarsoftkotlin.data.remote.retrofit.ConnectivityInterceptorImpl
import com.mif50.madarsoftkotlin.data.remote.retrofit.NoConnectivityException
import com.mif50.madarsoftkotlin.ui.base.ui.BaseActivity
import com.mif50.madarsoftkotlin.ui.weather.items.ItemWeather
import com.mikepenz.fastadapter.IItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
@LayoutRes(R.layout.activity_weather)
class WeatherActivity : BaseActivity(), WeatherNavigator {


    private var location: LocationAddress? = null
    private val weatherViewModel: WeatherViewModel<WeatherNavigator> by viewModel()

    private val fastItemAdapter = FastItemAdapter<IItem<*, *>>()

    companion object {
        private const val EXTRA_LOCATION = "location_data"

        fun getStartIntent(location: LocationAddress): Intent = Intent()
            .putExtra(EXTRA_LOCATION, location)
    }

    override fun bindView(savedInstanceState: Bundle?) {
        weatherViewModel.attachNavigator(this)

        location = intent?.getSerializableExtra(EXTRA_LOCATION) as LocationAddress?
        initAdapter()

        // this link of  ->  https://samples.openweathermap.org/data/2.5/forecast/daily?appid=b1b15e88fa797225412429c1c50c122a1&cnt=10&lon=29.025242552161217&lat=24.119916808122483
        // change arrange of data in url return 404
        // not work with fast network so that I used retrofit

//        location?.let {
//            weatherViewModel.callApiGetWeather(RequestPlace(lat = it.lat, lon = it.lng))
//        }


        val apiService = ApiServices(ConnectivityInterceptorImpl(this))
        GlobalScope.launch(Dispatchers.Main) {

            try {
                val weather = apiService.getCurrentWeather(lat = location!!.lat, log = location!!.lng).await()

                groupLoading.visibility = View.GONE
                cityTv.text = String.format("City : %s", weather.city.mName)
                countryTv.text = String.format("country code  : %s", weather.city.mCountry)
                weather.list.map {
                    fastItemAdapter.add(ItemWeather().withItem(it))
                }
            } catch (e: NoConnectivityException) {
                Toast.makeText(this@WeatherActivity, "No internet connection", Toast.LENGTH_LONG).show()
                Log.e("Connectivity", "No internet connection", e)
            }

        }


    }

    private fun initAdapter() {
        tempRv.apply {
            adapter = fastItemAdapter
            layoutManager = LinearLayoutManager(this@WeatherActivity)
        }
    }

    override fun showWeatherData(weather: Place) {
        groupLoading.visibility = View.GONE
        cityTv.text = String.format("City : %s", weather.city.mName)
        countryTv.text = String.format("country code  : %s", weather.city.mCountry)
        weather.list.map {
            fastItemAdapter.add(ItemWeather().withItem(it))
        }

    }

}
