package com.mif50.madarsoftkotlin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
@Database(entities = [LocationAddress::class], version = 1 , exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun LocationDao(): LocationDao
}