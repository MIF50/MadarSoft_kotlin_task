package com.mif50.madarsoftkotlin.data

import com.mif50.madarsoftkotlin.data.local.db.DbManager
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import com.mif50.madarsoftkotlin.data.remote.ApiHeader
import com.mif50.madarsoftkotlin.data.remote.ApiManager
import com.mif50.madarsoftkotlin.data.remote.api.model.Place
import com.mif50.madarsoftkotlin.data.remote.api.model.RequestPlace
import io.reactivex.Flowable
import io.reactivex.Single

class DataManagerRepository(var apiManager: ApiManager, var dbManager: DbManager) : DataManager {

    init {
        apiManager.apiHeader()
    }

    override fun apiHeader(): ApiHeader {
        return apiManager.apiHeader()
    }

    override fun getPlaceData(request: RequestPlace): Single<Place> {
        return apiManager.getPlaceData(request).doOnSuccess {}
    }

    override fun insertLocation(item: LocationAddress): Long? {
        return dbManager.insertLocation(item)
    }

    override fun getAll(): Flowable<List<LocationAddress>> {
        return dbManager.getAll()
    }

    override fun delete(location: LocationAddress): Int {
        return dbManager.delete(location)
    }

}