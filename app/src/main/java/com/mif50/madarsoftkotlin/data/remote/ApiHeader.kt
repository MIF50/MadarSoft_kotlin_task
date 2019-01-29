package com.mif50.madarsoftkotlin.data.remote

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiHeader(
    @SerializedName("App-Version")
    val appVersion: String = "1.0",
    @SerializedName("Accept")
    val accept:String = "application/json",
    @SerializedName("Content-Type")
    val type: String = "application/json"
//    @SerializedName("appid")
//    val appid: String = "45eb0fd84bbb9b254cf192579133b91b"
):Serializable{
    init {
        toString()
    }

    override fun toString(): String {
        return "ApiHeader(appVersion='$appVersion', Accept='$accept', Content-Type='$type')"
    }
}