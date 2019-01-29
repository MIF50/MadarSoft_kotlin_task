package com.mif50.madarsoftkotlin.data.local.db.location

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "locations")
data class LocationAddress(
    var lat: Double,
    var lng: Double
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}