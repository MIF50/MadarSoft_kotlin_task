package com.mif50.madarsoftkotlin.data.local.db

import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import io.reactivex.Flowable
import io.reactivex.Maybe

interface DbManager{

//     fun insertAll(vararg items: LocationAddress): List<Long>

     fun insertLocation(item: LocationAddress): Long?

     fun getAll(): Flowable<List<LocationAddress>>

     fun delete(location: LocationAddress): Int
}