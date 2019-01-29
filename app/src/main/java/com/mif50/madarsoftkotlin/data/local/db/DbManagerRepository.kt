package com.mif50.madarsoftkotlin.data.local.db

import android.content.Context
import androidx.room.Room
import com.mif50.madarsoftkotlin.data.local.db.location.LocationAddress
import io.reactivex.Flowable

class DbManagerRepository(context: Context):DbManager{

//    override fun insertAll(vararg items: LocationAddress): List<Long> {
//        return database.LocationDao().insertAll(items)
//    }

    override fun insertLocation(item: LocationAddress): Long? {
        return database.LocationDao().insertLocation(item)
    }

    override fun getAll(): Flowable<List<LocationAddress>> {
        return database.LocationDao().getAll()
    }

    override fun delete(location: LocationAddress): Int {
      return database.LocationDao().delete(location)
    }

    private val ROOM_DB_NAME = "tv_database"
    val database: AppDataBase by lazy { Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, ROOM_DB_NAME).allowMainThreadQueries().build() }
}