package com.mif50.madarsoftkotlin.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress

@Database(entities = [LocationAddress::class], version = 1 , exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun LocationDao(): LocationDao
}