package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Place(
    @SerializedName("city") var city: City,
    @SerializedName("cnt") var cnt: Int,
    @SerializedName("list") var list: List<ListData>
) : Model(), Serializable