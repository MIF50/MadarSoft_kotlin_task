package com.mif50.madarsoftkotlin.data.remote.api.model

import com.google.gson.annotations.SerializedName

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
// https://samples.openweathermap.org/data/2.5/forecast/daily?    lat=35 & lon=139 & cnt=10 & appid=b1b15e88fa797225412429c1c50c122a1

// https://samples.openweathermap.org/data/2.5/forecast/daily?     appid=b1b15e88fa797225412429c1c50c122a1 & cnt=10 & lon=135.0 & lat=35.0

// https://samples.openweathermap.org/data/2.5/forecast/daily?appid=b1b15e88fa797225412429c1c50c122a1&cnt=10&lon=135.0&lat=35.0