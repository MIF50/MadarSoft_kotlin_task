package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
data class City(
        @SerializedName("country") val mCountry: String,
        @SerializedName("geoname_id") val mGeonameId: Long,
        @SerializedName("iso2") val mIso2: String,
        @SerializedName("lat") val mLat: Double,
        @SerializedName("lon") val mLon: Double,
        @SerializedName("name") val mName: String,
        @SerializedName("population") val mPopulation: Long,
        @SerializedName("type") val mType: String
)