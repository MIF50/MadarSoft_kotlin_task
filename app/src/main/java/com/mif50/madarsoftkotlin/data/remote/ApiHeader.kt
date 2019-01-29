package com.mif50.madarsoftkotlin.data.remote

import com.google.gson.annotations.SerializedName
import java.io.Serializable


/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
data class ApiHeader(
    @SerializedName("App-Version")
    val appVersion: String = "1.0",
    @SerializedName("Accept")
    val accept:String = "application/json",
    @SerializedName("Content-Type")
    val type: String = "application/json"
):Serializable{
    init {
        toString()
    }

    override fun toString(): String {
        return "ApiHeader(appVersion='$appVersion', Accept='$accept', Content-Type='$type')"
    }
}