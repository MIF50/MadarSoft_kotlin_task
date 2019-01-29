package com.mif50.madarsoftkotlin.data.local.db.location

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
@Entity(tableName = "locations")
data class LocationAddress(
    var lat: Double,
    var lng: Double
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}