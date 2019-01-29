package com.mif50.madarsoftkotlin.data.local.db

import androidx.room.*
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import io.reactivex.Flowable


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
@Dao
interface LocationDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertAll(vararg locations: LocationAddress): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLocation(item: LocationAddress): Long?

    @Query("SELECT * FROM locations")
    fun getAll(): Flowable<List<LocationAddress>>

    @Delete
    fun delete(location: LocationAddress): Int
}