package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
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