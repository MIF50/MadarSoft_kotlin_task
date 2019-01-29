package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
data class ListData(
    @SerializedName("clouds")  val mClouds: Long,
    @SerializedName("deg")  val mDeg: Long,
    @SerializedName("dt")  val mDt: Long,
    @SerializedName("humidity")  val mHumidity: Long,
    @SerializedName("pressure")  val mPressure: Double,
    @SerializedName("speed")  val mSpeed: Double,
    @SerializedName("temp")  val mTemp: Temp,
    @SerializedName("weather")  val mWeather: ArrayList<Weather>
)