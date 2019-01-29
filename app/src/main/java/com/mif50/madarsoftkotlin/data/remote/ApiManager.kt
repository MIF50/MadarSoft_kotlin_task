package com.mif50.madarsoftkotlin.data.remote

import com.mif50.madarsoftkotlin.data.remote.api.model.Place
import com.mif50.madarsoftkotlin.data.remote.api.model.RequestPlace
import io.reactivex.Single

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
interface ApiManager {

    fun apiHeader(): ApiHeader
    fun getPlaceData(request: RequestPlace): Single<Place>
}