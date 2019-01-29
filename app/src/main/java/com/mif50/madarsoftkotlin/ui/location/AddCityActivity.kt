package com.mif50.madarsoftkotlin.ui.location

import android.content.Context
import android.content.Intent
import android.location.Address
import android.location.Location
import android.os.Bundle
import android.util.Log
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.mif50.madarsoftkotlin.R
import com.mif50.madarsoftkotlin.app.helper.ui.LayoutRes
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import com.mif50.madarsoftkotlin.ui.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_add_city.*
import org.koin.androidx.viewmodel.ext.android.viewModel



/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
@LayoutRes(R.layout.activity_add_city)
class AddCityActivity : BaseActivity(), OnMapReadyCallback, GoogleMap.OnMapClickListener, AddCityNavigator {
    private val TAG = AddCityActivity::class.java.simpleName

    private val addCityViewModel: AddCityViewModel<AddCityNavigator> by viewModel()


    private var mMap: GoogleMap? = null

    var count = 0


    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, AddCityActivity::class.java)
    }

    override fun bindView(savedInstanceState: Bundle?) {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment =
                supportFragmentManager.findFragmentById(com.mif50.madarsoftkotlin.R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        initViewModel()
    }

    private fun initViewModel() {
        addCityViewModel.attachNavigator(this)
    }

    override fun onResume() {
        super.onResume()
        checkPlayServicesAvailable()
    }

    override fun onMapReady(googleMap: GoogleMap?) {

        mMap = googleMap
        mMap?.let {
            it.setOnMapClickListener(this)
            it.uiSettings.isZoomControlsEnabled = true
            it.uiSettings.isMyLocationButtonEnabled = true
            it.uiSettings.setAllGesturesEnabled(true)

        }


        // Add a marker in Sydney and move the camera

    }


    override fun onMapClick(latLng: LatLng?) {
        val location = Location("")
        latLng?.let {
            location.latitude = it.latitude
            location.longitude = it.longitude

        }
//        mMap?.clear()
        drawClickedLocation(location)

        addCityViewModel.addLocation(LocationAddress(location.latitude, location.longitude))
    }

    override fun numberLocationAdded() {
        countLocationTv.text = String.format("numbers of chosen places =  %d ", ++count)
    }


    private fun drawClickedLocation(location: Location) {
        val currentLocation = LatLng(location.latitude, location.longitude)
        mMap?.addMarker(MarkerOptions().position(currentLocation).title(resources.getString(R.string.current_location)))
        mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 14.0f))

    }

    private fun drawCurrentLocation(address: Address) {
        val latLng = LatLng(address.latitude, address.longitude)
        mMap?.addMarker(MarkerOptions().position(latLng).title(address.featureName))
        mMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14.0f))
    }

    private fun checkPlayServicesAvailable() {
        val apiAvailability = GoogleApiAvailability.getInstance()
        val status = apiAvailability.isGooglePlayServicesAvailable(this)

        if (status != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(status)) {
                apiAvailability.getErrorDialog(this, status, 1).show()

            } else {
                Log.e("lastUpdate", "Google Play Services unavailable. This app will not work")
            }
        }
    }

}
