package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Weather(
    @SerializedName("description")  val mDescription: String,
    @SerializedName("icon")  val mIcon: String,
    @SerializedName("id")  val mId: Long,
    @SerializedName("main")  val mMain: String): Serializable