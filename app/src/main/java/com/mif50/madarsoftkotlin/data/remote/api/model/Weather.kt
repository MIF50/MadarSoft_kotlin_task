package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
data class Weather(
    @SerializedName("description")  val mDescription: String,
    @SerializedName("icon")  val mIcon: String,
    @SerializedName("id")  val mId: Long,
    @SerializedName("main")  val mMain: String): Serializable