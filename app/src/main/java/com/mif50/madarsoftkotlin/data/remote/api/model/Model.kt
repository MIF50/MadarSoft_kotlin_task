package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class Model(
    @SerializedName("cod") var response: String = "" ,
    @SerializedName("message") var message: String = ""
)