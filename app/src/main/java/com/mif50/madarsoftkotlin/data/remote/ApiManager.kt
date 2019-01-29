package com.mif50.madarsoftkotlin.data.remote

import com.mif50.madarsoftkotlin.data.remote.api.model.Place
import com.mif50.madarsoftkotlin.data.remote.api.model.RequestPlace
import io.reactivex.Single

interface ApiManager {

    fun apiHeader(): ApiHeader
    fun getPlaceData(request: RequestPlace): Single<Place>
}