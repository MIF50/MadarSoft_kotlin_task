package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 *  @name Mohamed ibrahim
 *  @email mohamedibrahim1223@gmail.com
 * Copyrights (c) 1/27/19 Created By MIF50
 **/
data class Place(
    @SerializedName("city") var city: City,
    @SerializedName("cnt") var cnt: Int,
    @SerializedName("list") var list: List<ListData>
) : Model(), Serializable