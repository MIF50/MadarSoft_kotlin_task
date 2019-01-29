package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName

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