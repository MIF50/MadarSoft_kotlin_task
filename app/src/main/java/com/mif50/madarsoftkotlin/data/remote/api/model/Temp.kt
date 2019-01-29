package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName

data class Temp(
    @SerializedName("day")
    private val mDay: Double,
    @SerializedName("eve")
    private val mEve: Double,
    @SerializedName("max")
    private val mMax: Double,
    @SerializedName("min")
    private val mMin: Double,
    @SerializedName("morn")
    private val mMorn: Double,
    @SerializedName("night")
    private val mNight: Double

)