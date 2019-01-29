package com.mif50.madarsoftkotlin.data.remote

import com.google.gson.reflect.TypeToken
import com.mif50.madarsoftkotlin.data.remote.api.model.Place
import com.mif50.madarsoftkotlin.data.remote.api.model.RequestPlace
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
class ApiManagerRepository(private var apiHeader: ApiHeader) : ApiManager {


    init {
        apiHeader = apiHeader()
    }

    override fun apiHeader(): ApiHeader {
        return apiHeader
    }

    override fun getPlaceData(request: RequestPlace): Single<Place> {
        val map = HashMap<String, String>()
        map["cnt"] = request.cnt.toString()
        map["appid"] = request.appid
        map["lat"] = request.lat.toString()
        map["lon"] = request.lon.toString()

        return Rx2AndroidNetworking.get("https://samples.openweathermap.org/data/2.5/forecast/daily")
                .addHeaders(apiHeader)
                .addQueryParameter(map)
                .build()
                .getParseSingle(object : TypeToken<Place>() {})

    }

}