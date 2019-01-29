package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
data class RequestPlace(
    @SerializedName("appid")
    val appid: String = "b1b15e88fa797225412429c1c50c122a1",
    @SerializedName("cnt")
     var cnt: Int = 10,
    @SerializedName("lon")
     var lon: Double,
    @SerializedName("lat")
     var lat: Double


)