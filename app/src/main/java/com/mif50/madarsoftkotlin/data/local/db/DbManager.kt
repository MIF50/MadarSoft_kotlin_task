package com.mif50.madarsoftkotlin.data.local.db

import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import io.reactivex.Flowable
import io.reactivex.Maybe


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
interface DbManager{

//     fun insertAll(vararg items: LocationAddress): List<Long>

     fun insertLocation(item: LocationAddress): Long?

     fun getAll(): Flowable<List<LocationAddress>>

     fun delete(location: LocationAddress): Int
}